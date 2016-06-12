package application.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Crate {

	    @Id 
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	    private int freeSpaces;
		
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "crate", cascade = CascadeType.ALL)
		private Set<Bottle> bottles = new HashSet<Bottle>();
		
		@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    private Drink drink;
	  
	    public Crate() {}
	    
	    public Crate(long id) { 
	        this.id = id;
	      }

	    public Crate(int freeSpaces) {
			this();
			this.freeSpaces = freeSpaces;
		
		}

		@Column(name = "bottle_id", unique = true, nullable = false)
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

		public int getFreeSpaces() {
			return freeSpaces;
		}

		public void setFreeSpaces(int freeSpaces) {
			this.freeSpaces = freeSpaces;
		}

		public Set<Bottle> getBottles() {
			return bottles;
		}

		public void setBottles(Set<Bottle> bottles) {
			this.bottles = bottles;
		}

		public Drink getDrink() {
			return drink;
		}

		public void setDrink(Drink drink) {
			this.drink = drink;
		}

		@Override
		public String toString() {
			return "Crate [id=" + id + ", freeSpaces=" + freeSpaces
					+ ", bottles=" + bottles + ", drink=" + drink + "]";
		}
	    
	    
		

}
