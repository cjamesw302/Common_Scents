package org.cjwilliams.commonscents.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Order entity class

@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate = new Date(System.currentTimeMillis());

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "userID", nullable=false)
	private Users users;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "productID")
	private Products products;

	//No args constructor for orders
	
	public Orders() {
		super();
	}

	//All args constructor for orders
	
	public Orders(Date orderDate, Users users) {
		super();
		this.orderDate = orderDate;
		this.users = users;
	}

	//Getters and setters for corresponding variables
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", users=" + users + "]";
	}
}