package entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "pizza_store.order")
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", unique = true, columnDefinition = "INTEGER(10)")
	private Integer order_id;

	@ManyToMany
	@JoinTable(name = "order_pizza", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "pizza_id") })
	private Set<Pizza> pizzas = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "order_sauce", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "sauce_id") })
	private Set<Sauce> sauces = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "order_drink", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "drink_id") })
	private Set<Drink> drinks = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "isProceeded")
	private boolean isProceeded;

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date")
	private java.util.Date orderDate;

	public Order() {
	}

	public Order(Set<Pizza> pizzas, Set<Sauce> sauces, Set<Drink> drinks,
			User user, boolean isProceeded, java.util.Date orderDate) {
		this.pizzas = pizzas;
		this.sauces = sauces;
		this.drinks = drinks;
		this.user = user;
		this.isProceeded = isProceeded;
		this.orderDate = orderDate;
	}

	public Integer getId() {
		return order_id;
	}

	public void setId(Integer id) {
		this.order_id = id;
	}

	public Set<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public Set<Sauce> getSauces() {
		return sauces;
	}

	public void setSauces(Set<Sauce> sauces) {
		this.sauces = sauces;
	}

	public Set<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(Set<Drink> drinks) {
		this.drinks = drinks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	};

	public Boolean getIsProceeded() {
		return isProceeded;
	}

	public void setIsProceeded(Boolean isProceeded) {
		this.isProceeded = isProceeded;
	}

	public java.util.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "order_id=" + order_id + ", pizzas=" + pizzas + ", sauces="
				+ sauces + ", drinks=" + drinks + ", user=" + user + "]";
	}
}
