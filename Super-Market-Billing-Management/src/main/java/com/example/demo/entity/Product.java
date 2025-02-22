package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "quantity")
	private int quantity;

	@Column(name="total")
	private int total;
	
	public Product() {
		
	}
	
	public Product(String productName, int price, int quantity, int total) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String p) {
		this.productName = p;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	} 
}
