package application.entities;

import java.util.Date;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Drink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, message = "Type is niet ingevoerd.")
	private String drinkType;
	
	@NotNull
	@Size(min = 1, message = "Naam is niet ingevoerd.")
	private String drinkName;
	
	@NotNull(message = "Datum is niet geselecteerd.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFounded;
	
	private boolean availability;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "drink", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Bottle> bottles = new HashSet<Bottle>();

	@OneToOne(cascade = CascadeType.ALL)
	private Neighbourhood neighbourhood;

	public Drink() {
	}

	public Drink(long id) {
		this.id = id;
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
		return neighbourhood;
	}

	public void setNeigbourhood(Neighbourhood neigbourhood) {
		this.neighbourhood = neigbourhood;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", drinkType=" + drinkType + ", drinkName="
				+ drinkName + ", dateFounded=" + dateFounded
				+ ", availability=" + availability + ", bottles=" + bottles
				+ ", neigbourhood=" + neighbourhood + "]";
	}

}
