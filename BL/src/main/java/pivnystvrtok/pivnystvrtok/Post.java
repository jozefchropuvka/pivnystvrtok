package pivnystvrtok.pivnystvrtok;

import org.joda.time.DateTime;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.user.User;


public class Post {
	
	@JsonProperty
	private String id;
	
	@JsonProperty
	private String entry;
	
	@JsonProperty
	@DBRef
	private User user;
	
	@JsonProperty
	@LastModifiedDate
	private DateTime date;

	public String getId() {
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
