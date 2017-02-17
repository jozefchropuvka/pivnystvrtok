package pivnystvrtok.restaurant;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.common.BaseEntity;

public class Restaurant extends BaseEntity{
	 	
	 	@JsonProperty
	 	@NotEmpty
	 	private String name;
	 	
	 	@JsonProperty
	 	@NotNull
	 	private Address address;


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}
}
