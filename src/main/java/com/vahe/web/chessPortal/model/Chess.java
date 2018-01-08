package com.vahe.web.chessPortal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Chess {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull @Size(min=1, max=100)
	private String name;
	@NotNull @Size(min=1, max=100)
	private String made;
	@NotNull @Size(min=20, max=60)
	private Integer dimension;
	@Size(min=5)
	private Float price;
	
	public Chess() {}
	
	public Chess(String name, String made, Float price, Integer dimension) {
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
