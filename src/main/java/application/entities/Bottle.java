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

@Entity
public class Bottle {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private String dateScanned;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
    private Drink drink;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BottleType bottleType;
	
    public Bottle() {}
    
    public Bottle(long id) { 
        this.id = id;
      }

    public Bottle(String dateScanned) {
		this();
		this.dateScanned = dateScanned;
	}
   

	@Column(name = "bottle_id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getDateScanned() {
		return dateScanned;
	}

	public void setDateScanned(String dateScanned) {
		this.dateScanned = dateScanned;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public BottleType getBottleType() {
		return bottleType;
	}

	public void setBottleType(BottleType bottleType) {
		this.bottleType = bottleType;
	}

	@Override
	public String toString() {
		return "Bottle [id=" + id + ", dateScanned=" + dateScanned + ", drink="
				+ drink + ", bottleType=" + bottleType
				+ "]";
	}


}

