package com.cogent.GreatOutdoors.security.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest implements Serializable {
	
private static final long serialVersionUID = 5926468583005350707L;
	
	@NotBlank
    @Email
    private String email;
    
    @NotBlank
    private String password;

}
