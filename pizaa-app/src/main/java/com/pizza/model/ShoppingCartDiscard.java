package com.pizza.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "pizza_store.shoppingCart")
@Entity
public class ShoppingCartDiscard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shoppingCart_id", unique = true, columnDefinition = "INTEGER(10)")
	private Integer shoppingCart_id;

	@ManyToOne
	@JoinColumn(name = "pizza_Id")
	private Pizza pizza;

	@ManyToOne
	@JoinColumn(name = "sauce_Id")
	private Sauce sauce;
	
	@ManyToOne
	@JoinColumn(name = "drink_Id")
	private Drink drink;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	public ShoppingCartDiscard() {
		
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}
