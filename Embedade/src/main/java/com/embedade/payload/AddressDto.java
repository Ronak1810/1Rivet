package com.embedade.payload;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
	
	@NotEmpty
	@Size(min=2,max=30,message="City name should be between 2 and 30 character")
	private String city;
	
	@NotEmpty
	@Size(min=2,max=30,message="State name should be between 2 and 30 character")
	private String state;
	
	@NotEmpty
	@Size(min=2,max=30,message="Coutry name should be between 2 and 30 character")
	private String country;
	
	
}
