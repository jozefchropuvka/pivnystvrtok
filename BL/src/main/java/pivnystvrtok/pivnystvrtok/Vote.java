package pivnystvrtok.pivnystvrtok;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.restaurant.Restaurant;
import pivnystvrtok.user.CurrentUserDetailsService;
import pivnystvrtok.user.User;

public class Vote {
	
	@Autowired
	CurrentUserDetailsService currentUser;

	@JsonProperty
	@DBRef
//	@NotNull
	private User user;
	
	@JsonProperty
	@DBRef
//	@NotNull
	private Restaurant restaurant;
	
	@JsonProperty
//	@NotNull
	private DateTime date;
	
	@JsonProperty
//	@NotNull
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
	public void setUser() {
		this.user = currentUser.getUser();
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
