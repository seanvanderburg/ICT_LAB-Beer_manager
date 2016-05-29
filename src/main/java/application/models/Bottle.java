package application.models;

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
    private String width;
    private String height;
    private String capacity;
	private String dateScanned;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Drink drink;
  
    public Bottle() {}
    
    public Bottle(long id) { 
        this.id = id;
      }

    public Bottle(String width, String height,
			String capacity, String dateScanned) {
		this();
		this.width = width;
		this.height = height;
		this.capacity = capacity;
		this.dateScanned = dateScanned;
	}
   

	@Column(name = "bottle_id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
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

	@Override
	public String toString() {
		return "Bottle [id=" + id + ", width=" + width
				+ ", height=" + height + ", capacity=" + capacity
				+ ", dateScanned=" + dateScanned + "]";
	}

	

}

