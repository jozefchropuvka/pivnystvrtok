package pivnystvrtok.pivnystvrtok;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.repository.NoRepositoryBean;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.common.BaseDocument;
import pivnystvrtok.restaurant.Restaurant;

public class PivnyStvrtok extends BaseDocument{
	
	@JsonProperty///TODO validation - has to be thursday
	@NotNull
	private DateTime date;
	
	@JsonProperty
	@DBRef
	@NotNull
	private Restaurant restaurant;
	
	@JsonProperty
	private List<Vote> votes;
	
	@JsonProperty
	@NotNull
	private State state;
	
	@JsonProperty
	private List<Post> posts;
	
	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
}
