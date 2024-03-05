package k24.Filmikino.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * Basic class for containing info on the different theater screens
 */

@Entity
public class Screens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String screenName;
	private int capacity;

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
