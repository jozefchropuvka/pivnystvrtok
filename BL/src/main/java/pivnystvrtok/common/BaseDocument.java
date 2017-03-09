package pivnystvrtok.common;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.user.User;

public class BaseDocument {

	@Id
    @JsonProperty
    @Indexed(unique=true)
    private String id;	

	public String getId() {
		return id;
	}
	
	@CreatedDate
	private DateTime createdDate;
	
	@LastModifiedDate
	private DateTime lastModified;
	
	@CreatedBy
	@DBRef
	private User user;
	
	@LastModifiedBy
	@DBRef
	private User lastModifiedBy;
}
