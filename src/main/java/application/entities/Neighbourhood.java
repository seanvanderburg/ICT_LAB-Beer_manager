package application.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * neighbourhood entity
 * @author Sean
 *
 */
@Entity
public class Neighbourhood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, message = "Naam is niet ingevoerd.")
	private String name;
	
	@NotNull
	@Size(min = 1, message = "Stad is niet ingevoerd.")
	private String city;
	
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Drink drink;

	public Neighbourhood() {
	}

	public Neighbourhood(long id) {
		this.id = id;
	}

	/**
	 * constructor
	 * @param name
	 * @param city
	 * @param description
	 */
	public Neighbourhood(String name, String city, String description) {
		this();
		this.name = name;
		this.city = city;
		this.description = description;
	}

	/**
	 * @return id
	 */
	@Column(name = "neigbourhood_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return drink
	 */
	public Drink getDrink() {
		return drink;
	}

	/**
	 * @param drink
	 */
	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	@Override
	public String toString() {
		return "Neigbourhood [id=" + id + ", name=" + name + ", city=" + city
				+ ", description=" + description + ", drink=" + drink + "]";
	}

}
