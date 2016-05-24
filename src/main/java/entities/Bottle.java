package entities;

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
    private double width;
    private double height;
    private double capacity;
	private String dateScanned;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Drink drink;
  
    public Bottle() {}

    public Bottle(double width, double height,
			double capacity, String dateScanned) {
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

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
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

