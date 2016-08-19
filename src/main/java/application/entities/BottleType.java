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
import javax.persistence.OneToMany;


@Entity
public class BottleType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private int capacityInCL;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "drink", cascade = CascadeType.ALL)
	private Set<Bottle> bottles = new HashSet<Bottle>();

	public BottleType() {
	}

	public BottleType(long id) {
		this.id = id;
	}

	public BottleType(String type, int capacityInCL) {
		this();
		this.type = type;
		this.capacityInCL = capacityInCL;
	}

	@Column(name = "bottle_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getcapacityInCL() {
		return capacityInCL;
	}

	public void setcapacityInCL(int capacityInCL) {
		this.capacityInCL = capacityInCL;
	}

	@Override
	public String toString() {
		return "BottleType [id=" + id + ", type=" + type + ", capacityInCL="
				+ capacityInCL + ", bottles=" + bottles + "]";
	}

}
