package com.cogent.GreatOutdoors.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	@JsonIgnore
	private String password;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private int pincode;
	
	@OneToMany(mappedBy = "user")
	private List<Orders> orderList;
	@OneToMany(mappedBy = "user")
	private List<Cart> cartList;
	
	public User(String firstName, String lastName, String phoneNumber, String email, String password,
			String addressLine1, String addressLine2, String state, int pincode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.pincode = pincode;
	}
}
