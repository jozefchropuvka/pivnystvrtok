package pivnystvrtok.pivnystvrtok;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.repository.NoRepositoryBean;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.common.BaseDocument;
import pivnystvrtok.restaurant.Restaurant;

public class PivnyStvrtok extends BaseDocument implements PivnyStvrtokSimple{
	
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
	private States state;
	
	@JsonProperty
	private List<Post> posts;

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		if(allowedDates().contains(date)){
			this.date = date;
		}		
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

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public List<DateTime> allowedDates(){
		List<DateTime> allowedDates = new ArrayList<>();
		if(state.equals(States.FINISHED)){
			DateTime today = new DateTime();
			int month = today.getMonthOfYear();
			DateTime nextDay = new DateTime();

		//find out where are we now
		
			month++;
			nextDay = new DateTime().plusMonths(1);

			while(month == nextDay.getMonthOfYear()){
				if(nextDay.dayOfWeek().equals(4)){
					allowedDates.add(nextDay);
				}
				nextDay = nextDay.plusDays(1);
			}
		}
		return allowedDates;
	}
}
