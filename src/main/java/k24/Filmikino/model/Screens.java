package k24.Filmikino.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/*
 * Basic class for containing info on the different theater screens
 * Validation rules added for new screens
 */

@Entity
@Table(name = "screens")
public class Screens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "screenid")
	private Long id;

	@NotEmpty(message = "Screen needs a name")
	@Size(min = 1, max = 50)
	@Column(name = "screenname")
	private String screenName;
	
	@Positive
	@Column(name = "capacity")
	private int capacity;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="screen")
	private List<Showings> showings;

	public Screens() {
		super();
	}

	public Screens(String screenName, int capacity) {
		super();
		this.screenName = screenName;
		this.capacity = capacity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Screens [id=" + id + ", screenName=" + screenName + ", capacity=" + capacity + "]";
	}

}
