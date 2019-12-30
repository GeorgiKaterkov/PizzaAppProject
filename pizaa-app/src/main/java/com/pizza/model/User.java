package com.pizza.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pizza.model.RoleEnum;

@Table(name = "pizza_store.user")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, columnDefinition = "INT(10)")
	private int id;
    @Column(name = "names", unique = true, nullable = false)
	private String username;
    @Column(name = "pass", nullable = false)
	private String password;  
    @Enumerated(EnumType.STRING)
	private RoleEnum role;    
    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
    
    public User(){ 	
    }
    
	public User(String name, String password, RoleEnum role) {
		//this.id = UUID.randomUUID();
		this.username = name;
		this.password = password;
		this.role = role;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		return "User [name=" + username + ", password=" + password + ", role="
				+ role + "]";
	}
}
