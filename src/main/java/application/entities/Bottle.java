package application.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Sean bottle entity
 */
@Entity
public class Bottle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dateScanned;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	private Drink drink;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private BottleType bottleType;

	public Bottle() {
	}

	public Bottle(long id) {
		this.id = id;
	}

	public Bottle(String dateScanned) {
		this();
		this.dateScanned = dateScanned;
	}

	/**
	 * @return id
	 */
	@Column(name = "bottle_id", unique = true, nullable = false)
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
	 * @return dateScanned
	 */
	public String getDateScanned() {
		return dateScanned;
	}

	/**
	 * @param dateScanned
	 */
	public void setDateScanned(String dateScanned) {
		this.dateScanned = dateScanned;
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

	/**
	 * @return bottleType
	 */
	public BottleType getBottleType() {
		return bottleType;
	}

	/**
	 * @param bottleType
	 */
	public void setBottleType(BottleType bottleType) {
		this.bottleType = bottleType;
	}

	@Override
	public String toString() {
		return "Bottle [id=" + id + ", dateScanned=" + dateScanned + ", drink="
				+ drink + ", bottleType=" + bottleType + "]";
	}

}
