package pivnystvrtok.pivnystvrtok;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.restaurant.Restaurant;
import pivnystvrtok.user.User;

public class Vote {
	
	@JsonProperty
	@DBRef
	@NotNull
	private User user;
	
	@JsonProperty
	@DBRef
	@NotNull
	private Restaurant restaurant;
	
	@JsonProperty
	@NotNull
	private DateTime date;
	
	@JsonProperty
	@NotNull
	private DateTime dateVoted;
	
	public DateTime getDateVoted() {
		return dateVoted;
	}
	public void setDateVoted(DateTime dateVoted) {
		this.dateVoted = dateVoted;
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
}
