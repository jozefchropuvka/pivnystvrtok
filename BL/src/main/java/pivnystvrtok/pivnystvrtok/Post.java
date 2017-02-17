package pivnystvrtok.pivnystvrtok;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Post {
	
	@Id
	@JsonProperty
	private String id;
	
	@JsonProperty
	private String entry;
	
	@JsonProperty
	private ObjectId user;
	
	@JsonProperty
	@LastModifiedDate
	private DateTime date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public ObjectId getUser() {
		return user;
	}

	public void setUser(ObjectId user) {
		this.user = user;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}
	
}
