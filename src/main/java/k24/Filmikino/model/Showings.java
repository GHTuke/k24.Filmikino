package k24.Filmikino.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.Future;

/*
 * Showings class to work as a link table between movies and screens.
 * Added Showingtime to primary key to allow multiple showings of the same movie in the same screen.
 * ShowingsKey works as embedded primary key.
 */
@Entity
public class Showings {
	
	@EmbeddedId
	private ShowingsKey id;
	
	@ManyToOne
	@MapsId("movieId")
	@JoinColumn(name = "movieid")
	private Movies movie;
	
	@ManyToOne
	@MapsId("screenId")
	@JoinColumn(name = "screenid")
	private Screens screen;
	
	@Future(message = "New showing has to be in the future")
	@Column(insertable=false, updatable=false)
	private LocalDateTime showingtime;

	public Showings() {
		super();
	}

	public Showings(Movies movie, Screens screen, LocalDateTime showingtime) {
		super();
		this.movie = movie;
		this.screen = screen;
		this.showingtime = showingtime;
		this.id = new ShowingsKey(movie.getId(), screen.getId(), showingtime);
	}

	public ShowingsKey getId() {
		return id;
	}

	public void setId(ShowingsKey id) {
		this.id = id;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	public Screens getScreen() {
		return screen;
	}

	public void setScreen(Screens screen) {
		this.screen = screen;
	}

	public LocalDateTime getShowingtime() {
		return showingtime;
	}

	public void setShowingtime(LocalDateTime showingtime) {
		this.showingtime = showingtime;
	}
	
	//Formatted getter for hour that adds extra 0 infront of single digit hours.
	public String getHour() {
		if (showingtime.getHour() < 10) {
			return "0" + showingtime.getHour();
		} else {
			return "" + showingtime.getHour();
		}
	}
	
	//Formatted getter for minutes that adds extra 0 infront of single digit minutes.
	public String getMinute() {
		if (showingtime.getMinute() < 10) {
			return "0" + showingtime.getMinute();
		} else {
			return "" + showingtime.getMinute();
		}
	}
	
	

}
