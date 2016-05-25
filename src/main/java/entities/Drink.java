package entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Drink {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String drinkType;
	private String drinkName;
	private Date dateFounded;
	private boolean availability;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="drink", cascade = CascadeType.ALL) 
    private Set<Bottle> bottles = new HashSet<Bottle>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private Neighbourhood neigbourhood;

	public Drink() {
	}
	
	public Drink(String drinkType, String drinkName, Date dateFounded,
			boolean availability) {
		this();
		this.drinkType = drinkType;
		this.drinkName = drinkName;
		this.dateFounded = dateFounded;
		this.availability = availability;
	}

	@Column(name = "drink_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(String drinkType) {
		this.drinkType = drinkType;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public Date getDateFounded() {
		return dateFounded;
	}

	public void setDateFounded(Date dateFounded) {
		this.dateFounded = dateFounded;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Set<Bottle> getBottles() {
		return bottles;
	}

	public void setBottles(Set<Bottle> bottles) {
		this.bottles = bottles;
	}

	public Neighbourhood getNeigbourhood() {
		return neigbourhood;
	}

	public void setNeigbourhood(Neighbourhood neigbourhood) {
		this.neigbourhood = neigbourhood;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", drinkType=" + drinkType + ", drinkName="
				+ drinkName + ", dateFounded=" + dateFounded
				+ ", availability=" + availability + ", bottles=" + bottles
				+ ", neigbourhood=" + neigbourhood + "]";
	}
	
}
