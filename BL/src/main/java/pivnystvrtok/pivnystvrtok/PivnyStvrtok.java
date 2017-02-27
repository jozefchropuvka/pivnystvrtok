package pivnystvrtok.pivnystvrtok;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.common.BaseDocument;
import pivnystvrtok.restaurant.Restaurant;

@Document
public class PivnyStvrtok extends BaseDocument {
	
	@JsonProperty
	private DateTime date;
	
	@JsonProperty
	@DBRef
	private Restaurant restaurant;
	
	@JsonProperty
	private List<Vote> votes;
	
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
