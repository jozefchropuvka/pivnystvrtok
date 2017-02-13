package pivnystvrtok.restaurant;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Address {
	
	@JsonProperty
	private String street;
	@JsonProperty
	private String zipcode;
	@JsonProperty
	@Size(max=2)
	private BigDecimal[] coord;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public BigDecimal[] getCoord() {
		return coord;
	}
	public void setCoord(BigDecimal[] coord) {
		this.coord = coord;
	} 
	
}
