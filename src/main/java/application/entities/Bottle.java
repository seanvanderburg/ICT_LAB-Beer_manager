package application.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bottle {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private String dateScanned;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Drink drink;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Crate crate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BottleType bottleType;
	
    public Bottle() {}
    
    public Bottle(long id) { 
        this.id = id;
      }

    public Bottle(String width, String height,
			String capacity, String dateScanned) {
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

	public Crate getCrate() {
		return crate;
	}

	public void setCrate(Crate crate) {
		this.crate = crate;
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
				+ drink + ", crate=" + crate + ", bottleType=" + bottleType
				+ "]";
	}


}

