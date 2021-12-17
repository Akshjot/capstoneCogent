package com.cogent.GreatOutdoors.security.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest implements Serializable {
	
	private static final long serialVersionUID = 5926468583005150707L;
	 
    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    private String password;
    
    @NotBlank
	private String firstName;
    @NotBlank
	private String lastName;
    @NotBlank
	private String phoneNumber;
    @NotBlank
	private String addressLine1;
    @NotBlank
	private String addressLine2;
    @NotBlank
	private String state;
    @NotBlank
	private int pincode;

}
