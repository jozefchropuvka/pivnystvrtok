package pivnystvrtok.pivnystvrtok;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vote {
	
	@JsonProperty
	private ObjectId user;
	
	@JsonProperty
	private ObjectId restaurant;
	
	@JsonProperty
	private DateTime date;
	
	public ObjectId getUser() {
		return user;
	}
	public void setUser(ObjectId user) {
		this.user = user;
	}
	public ObjectId getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(ObjectId restaurant) {
		this.restaurant = restaurant;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
}
