package k24.Filmikino.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
	private Long id;

	@NotEmpty(message = "Movie name cannot be empty")
	@Size(min=2, max=100, message = "Movie name has to be between 2 and 100 characters")
	private String movieName;

	@Positive
	private int releaseYear;
	
	@NotEmpty(message = "Director needs a first name")
	@Size(min = 2, max = 30, message = "Name has to be between 2 and 30 characters long")
	private String directorFname;
	
	@NotEmpty(message = "Director needs a last name")
	@Size(min = 2, max = 30, message = "Name has to be between 2 and 30 characters long")
	private String directorLname;
	
	@Size(min = 1, max = 500, message = "Description has to be between 2 and 500 characters")
	@Lob //Added annotation to get past 255char limit
	private String movieDescription;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "genreId")
	private Genres genre;

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
