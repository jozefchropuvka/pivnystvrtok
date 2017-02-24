package pivnystvrtok.common;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.statemachine.States;
@Document
public class BaseDocument {

	@Id
    @JsonProperty
    @NotEmpty
    @Indexed
    private String id;	

	public String getId() {
		return id;
	}

	@JsonProperty
	@NotNull
	private States state;
	
	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}
}
