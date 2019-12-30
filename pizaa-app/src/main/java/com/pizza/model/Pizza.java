package com.pizza.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "pizza_store.pizza")
@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pizza_Id", unique = true, columnDefinition = "INTEGER(10)")
	private Integer id;
	@Column(name = "namePizza", nullable = false)
	private String namePizza;
	@Enumerated(EnumType.STRING)
	private PizzaSizeEnum pizzaSize;
	@Column(name = "price", nullable = false, columnDefinition = "DECIMAL(10,2)")
	private BigDecimal price;
	@ManyToMany(mappedBy = "pizzas")
	private Set<Order> orders = new HashSet<>();

	public Pizza() {
	}

	public Pizza(String namePizza, PizzaSizeEnum pizzaSize, BigDecimal price) {
		this.namePizza = namePizza;
		this.pizzaSize = pizzaSize;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamePizza() {
		return namePizza;
	}

	public void setNamePizza(String namePizza) {
		this.namePizza = namePizza;
	}

	public PizzaSizeEnum getPizzaSize() {
		return pizzaSize;
	}

	public void setPizzaSize(PizzaSizeEnum pizzaSize) {
		this.pizzaSize = pizzaSize;
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
		return "Option: " + id + " - " + namePizza + " - " + pizzaSize + " - "
				+ price + "lv";
	}
}
