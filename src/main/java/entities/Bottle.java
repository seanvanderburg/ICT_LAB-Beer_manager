package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Bottle {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String name;
    
  
    public Bottle() {}

    public Bottle(String name) {
        this();
        this.name = name;
    }

	@Column(name = "player_id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}

	

      
}

