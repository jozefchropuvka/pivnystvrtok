package pivnystvrtok.pivnystvrtok;

import java.util.List;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.common.BaseEntity;

public class PivnyStvrtok extends BaseEntity{
	
	@JsonProperty
	private DateTime date;
	
	@JsonProperty
	private ObjectId restaurant;
	
	@JsonProperty
	private List<Vote> votes;
	
	@JsonProperty
	private State state;
	
	@JsonProperty
	private List<Post> posts;
	
	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public ObjectId getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(ObjectId restaurant) {
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
