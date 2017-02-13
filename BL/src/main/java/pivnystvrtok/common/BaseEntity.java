package pivnystvrtok.common;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.action.Update;

public class BaseEntity {

	@Id
    @JsonProperty
    @NotEmpty(groups={Update.class})
    private ObjectId id;	

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

}
