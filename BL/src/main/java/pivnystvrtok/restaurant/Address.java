package pivnystvrtok.restaurant;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Address {
	
	@JsonProperty
	private String street;
	@JsonProperty
	private int zipcode;
	@JsonProperty
	@Size(max=2)
	private BigDecimal[] coord;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(String street, int zipcode, BigDecimal[] coord ) {
		this.street = street;
		this.zipcode = zipcode;
		this.coord = coord;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public BigDecimal[] getCoord() {
		return coord;
	}
	public void setCoord(BigDecimal[] coord) {
		this.coord = coord;
	} 
	
}
