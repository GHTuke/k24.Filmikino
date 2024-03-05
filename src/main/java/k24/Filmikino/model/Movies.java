package k24.Filmikino.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * Basic class for containing info on different movies
 */

@Entity
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String movieName;
	private int publicationYear;
	private String directorFname;
	private String directorLname;
	private String movieDescription;

	public Movies() {
		super();
	}

	public Movies(String movieName, int publicationYear, String directorFname, String directorLname,
			String movieDescription) {
		super();
		this.movieName = movieName;
		this.publicationYear = publicationYear;
		this.directorFname = directorFname;
		this.directorLname = directorLname;
		this.movieDescription = movieDescription;
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

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
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
		return "Movies [id=" + id + ", movieName=" + movieName + ", publicationYear=" + publicationYear
				+ ", directorFname=" + directorFname + ", directorLname=" + directorLname + ", movieDescription="
				+ movieDescription + "]";
	}

}
