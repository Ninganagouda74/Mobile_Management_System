package com.nrk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mobile")
public class Mobile {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String model;
	
	private int price;
	
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getimage() {
		return image;
	}

	public void setimage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
   
	
	

	
	public int getPrice() {
		return price;
	}

	
	@Override
	public String toString() {
		return "Mobile [name=" + name + ", model=" + model + ", price=" + price + ", image=" + image + "]";
	}

	public void setprice(int price) {
		this.price = price;
		
	}

	
	

	

	

}
