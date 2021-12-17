package com.cogent.GreatOutdoors.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
	@ApiModelProperty(notes = "ID of the product",name="id",required=true,value="test id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;
	@ApiModelProperty(notes = "name of the product",name="name",required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "description of the product",name="description",required=true,value="test desc")
	private String description;
	@ApiModelProperty(notes = "price of the product",name="price",required=true,value="test price")
	private float price;
	@ApiModelProperty(notes = "category of the product",name="category",required=true,value="test category")
	private String category;
}
