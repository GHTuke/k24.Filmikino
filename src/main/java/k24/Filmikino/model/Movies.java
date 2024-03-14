package k24.Filmikino.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/*
 * Basic class for containing info on different movies
 * Contains validation rules for adding new movies
 */

@Entity
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movieid")
	private Long id;

	@NotEmpty(message = "Movie name cannot be empty")
	@Size(max=100, message = "Movie name cannot exceed 100 characters")
	private String movieName;

	@Positive(message = "Year has to be positive number")
	private int releaseYear;
	
	@NotEmpty(message = "Director needs a first name")
	@Size(max = 30, message = "First name cannot exceed 30 characters")
	private String directorFname;
	
	@NotEmpty(message = "Director needs a last name")
	@Size(max = 30, message = "Last name cannot exceed 30 characters")
	private String directorLname;
	
	@Column(columnDefinition = "TEXT") //Allows for more than 255 characters
	@Size(min = 1, max = 500, message = "Description has to be between 1 and 500 characters")
	private String movieDescription;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "genreId")
	private Genres genre;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="movie")
	private List<Showings> showings;
	

	public Movies() {
		super();
	}

	public Movies(String movieName, int releaseYear, String directorFname, String directorLname,
			String movieDescription, Genres genre) {
		super();
		this.movieName = movieName;
		this.releaseYear = releaseYear;
		this.directorFname = directorFname;
		this.directorLname = directorLname;
		this.movieDescription = movieDescription;
		this.genre = genre;
	}

	public Genres getGenre() {
		return genre;
	}

	public void setGenre(Genres genre) {
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDirectorFname() {
		return directorFname;
	}

	public void setDirectorFname(String directorFname) {
		this.directorFname = directorFname;
	}

	public String getDirectorLname() {
		return directorLname;
	}
	
	//Extra getter for name combination in the format of "J, Doe"
	public String getDirectorShorthandname() {
		if (directorFname == null) {
		return directorLname; }
		else {
		return directorFname.charAt(0) + ", " + directorLname; 
		}
	}

	public void setDirectorLname(String directorLname) {
		this.directorLname = directorLname;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", movieName=" + movieName + ", releaseYear=" + releaseYear
				+ ", directorFname=" + directorFname + ", directorLname=" + directorLname + ", movieDescription="
				+ movieDescription + "]";
	}

}
