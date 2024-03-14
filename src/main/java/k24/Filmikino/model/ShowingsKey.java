package k24.Filmikino.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/*
 * Works as the multiattribute primary key for Showings class.
 */
@Embeddable
public class ShowingsKey implements Serializable {
	
	@Column(name = "movieid")
	private Long movieId;
	
	@Column(name = "screenid")
	private Long screenId;
	
	private LocalDateTime showingtime;

	public ShowingsKey() {
		super();
	}

	public ShowingsKey(Long movieId, Long screenId, LocalDateTime showingtime) {
		super();
		this.movieId = movieId;
		this.screenId = screenId;
		this.showingtime = showingtime;
	}

	public Long getMovieId() {
		return movieId;
	}
	
	public void setMovieId(Movies movieId) {
		this.movieId = movieId.getId();
	}
	
	//public void setMovieId(Long movieId) {
	//	this.movieId = movieId;
	//}

	public Long getScreenId() {
		return screenId;
	}
	
	public void setScreenId(Screens screenId) {
		this.screenId = screenId.getId();
	}
	
	//public void setScreenId(Long screenId) {
	//	this.screenId = screenId;
	//}

	public LocalDateTime getShowingtime() {
		return showingtime;
	}

	public void setShowingtime(LocalDateTime showingtime) {
		this.showingtime = showingtime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieId, screenId, showingtime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowingsKey other = (ShowingsKey) obj;
		return Objects.equals(movieId, other.movieId) && Objects.equals(screenId, other.screenId)
				&& Objects.equals(showingtime, other.showingtime);
	}
	
	

}