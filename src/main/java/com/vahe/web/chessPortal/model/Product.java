package com.vahe.web.chessPortal.model;

public class Product {

	private Long id;
	
	private String name;
	
	private String made;
	
	private Integer dimension;

	private Float price;
	
	public Product() {}
	
	public Product(String name, String made, Float price, Integer dimension) {
        this.name = name;
        this.made = made;
        this.price = price;
        this.dimension = dimension;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
	public Integer getDimension() {
		return dimension;
	}
	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ChessSet [id=" + id + ", name=" + name + ", made=" + made + ", dimension=" + dimension + ", price="
				+ price + "]";
	}
}
