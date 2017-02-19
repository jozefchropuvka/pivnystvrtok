package pivnystvrtok.common;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
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

}
