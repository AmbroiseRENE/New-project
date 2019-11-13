package com.fr.adaming.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class RegisterDto {

	@NotNull
	@NotEmpty
	@NotBlank
	private String nom;
	
	@Email
	@NotNull
	@NotEmpty
	@NotBlank
	private String email;

	@NotNull
	@NotEmpty
	@NotBlank
	private String pwd;
	

}
