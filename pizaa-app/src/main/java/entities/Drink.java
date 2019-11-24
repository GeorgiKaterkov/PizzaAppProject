package entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "pizza_store.drink")
@Entity
public class Drink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drink_Id", unique = true, columnDefinition = "INTEGER(10)")
	private Integer id;
	@Column(name = "drinkName", unique = true, nullable = false)
	private String drinkName;
	@Column(name = "price", nullable = false, columnDefinition = "DECIMAL(10,2)")
	private BigDecimal price;	
	@ManyToMany(mappedBy = "drinks")
	private Set<Order> orders = new HashSet<>();
	
	public Drink(){};
	
	public Drink(String drinkName, BigDecimal price) {		
		this.drinkName = drinkName;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}	

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Option: " + id + " - " + drinkName + " - "
				+ price + "lv";
	}	
}