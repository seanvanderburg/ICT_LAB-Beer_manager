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

	public Neighbourhood(String name, String city, String description) {
		this();
		this.name = name;
		this.city = city;
		this.description = description;
	}

	@Column(name = "neigbourhood_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	@Override
	public String toString() {
		return "Neigbourhood [id=" + id + ", name=" + name + ", city=" + city
				+ ", description=" + description + ", drink=" + drink + "]";
	}

}
