package com.vahe.web.chessPortal.javaBeans;

import java.io.Serializable; 
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue 
	private Long id;
	@NotNull @Size(min=1, max=20)
	private String name;
	@NotNull @Size(min=1, max=10)
	private String made;
	@NotNull @Min(5)
	private BigDecimal price;
	@NotNull
	private int dimension;
	@Column(length=800) @Size(min=1, max=300)
	private String description;	
	@Transient
	private String imageName;
	
	public Product() {}
	
	public Product(String name, String made, BigDecimal price, int dimension, String description, String imageName) {
        this.name = name;
        this.made = made;
        this.price = price;
        this.dimension = dimension;
        this.description = description;
        this.imageName = imageName;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getMade() {
		return made;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public int getDimension() {
		return dimension;
	}
	public String getDescription() {
		return description;
	}
	public String getImageName() {
		return imageName;
	}
	
	public String getShortDescription() {
        int i = description.indexOf('.');
        if (i >= 0 && i < 100) {
            return description.substring(0, i + 1);
        } else {
            return description.substring(0, Math.min(description.length(), 100)) + "...";
        }
    }
	
	@Override
	public String toString() {
		return "ChessSet [id=" + id + ", name=" + name + ", made=" + made + " price=" + price 
				+ ", dimension=" + dimension + "]";
	}
}
