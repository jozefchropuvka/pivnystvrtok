package pivnystvrtok.common;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseDocument {

	@Id
    @JsonProperty
    @Indexed(unique=true)
    private String id;	

	public String getId() {
		return id;
	}
	
	@LastModifiedDate
	private DateTime lastModified;
}
