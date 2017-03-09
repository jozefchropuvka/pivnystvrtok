package pivnystvrtok.pivnystvrtok;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.restaurant.Restaurant;
import pivnystvrtok.user.User;

public class Vote {
	
	@JsonProperty
	@DBRef
	private User user;
	
	@JsonProperty
	@DBRef
	private Restaurant restaurant;
	
	@JsonProperty
	private DateTime date;
	
	@JsonProperty
	@LastModifiedDate
	private DateTime lastModified;
	
	public Vote() {
		// TODO Auto-generated constructor stub
	}
	
	public Vote(Restaurant r, DateTime d) {
		restaurant = r;
		date = d;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	
	@Override
	public boolean equals(Object obj) {		
		return user.getId().equals(obj);
	}
}
