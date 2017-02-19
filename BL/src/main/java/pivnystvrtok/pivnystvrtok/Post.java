package pivnystvrtok.pivnystvrtok;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.user.User;


public class Post {
	
	@JsonProperty
	private ObjectId id;
	
	@JsonProperty
	private String entry;
	
	@JsonProperty
	@DBRef
	private User user;
	
	@JsonProperty
	@LastModifiedDate
	private DateTime date;

	public ObjectId getId() {
		return id;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}
	
}
