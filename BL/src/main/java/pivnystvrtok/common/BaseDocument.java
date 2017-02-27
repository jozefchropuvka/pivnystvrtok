package pivnystvrtok.common;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.statemachine.States;

public class BaseDocument {

	@Id
    @JsonProperty
    @Indexed
    private String id;	

	public String getId() {
		return id;
	}

	@JsonProperty
	private States state;
	
	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}
	
	@LastModifiedDate
	private DateTime lastModified;
}
