package pivnystvrtok.pivnystvrtok;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import pivnystvrtok.ApplicationExceptionCode;
import pivnystvrtok.user.CurrentUserDetailsService;
import pivnystvrtok.user.User;

@Service
public class PivnyStvrtokService {
	
	@Autowired
	private PivnyStvrtokRepository repository;	
	
	@Autowired
	private CurrentUserDetailsService currentUserService;
	
	public Vote submitVote(Vote vote){
		Assert.notNull(vote.getRestaurant());
		Assert.notNull(vote.getDate());
		PivnyStvrtok ps = repository.findCurrent().get(0);
		Assert.notNull(ps);
		if(ps.getState().equals(States.VOTED)){
			throw new ValidationException(ApplicationExceptionCode.VotingIsFinished.getMessage());
		}
		User user = currentUserService.getUser();
		Assert.notNull(user);
		vote.setUser(user);
		vote.setDateVoted(new DateTime());
		List<Vote> listVotes = ps.getVotes() == null ? new ArrayList<Vote>() : ps.getVotes();
		if(listVotes.isEmpty()){
			listVotes.add(vote);
		} else {
			boolean exists = false;
			for (Vote v : listVotes) {
				if(v.getUser().getId().equals(user.getId())){
					v.setDateVoted(new DateTime());
					v.setDate(vote.getDate());
					v.setRestaurant(vote.getRestaurant());
					exists = true;
					break;
				}
			}
			if(!exists){
				listVotes.add(vote);
			}
		}
		ps.setVotes(listVotes);
		repository.save(ps);
		return vote;
	}

	public Vote getVote() {
		Vote vote = new Vote();
		PivnyStvrtok ps = repository.findCurrent().get(0);
		Assert.notNull(ps);
		User u = currentUserService.getUser();
		Assert.notNull(u);
		List<Vote> listVotes = ps.getVotes() == null ? new ArrayList<Vote>() : ps.getVotes();
		for (Vote v : listVotes) {
			if (v.equals(u.getId())) {
				vote = v;
			}
		}
		return vote;
	}
	
	public List<DateTime> allowedDates(){
		PivnyStvrtok ps = repository.findCurrent().get(0);
		Assert.notNull(ps);
		List<DateTime> allowedDates = new ArrayList<>();
		if(ps.getState().equals(States.VOTING)){
			int month = ps.getDate().getMonthOfYear();
			DateTime nextDay = ps.getDate();
			if(nextDay.isBeforeNow()){
				nextDay = new DateTime();
			}
			while(month == nextDay.getMonthOfYear()){
				if(nextDay.dayOfWeek().get() == 4){
					allowedDates.add(nextDay);
				}
				nextDay = nextDay.plusDays(1);
			}
		}
		return allowedDates;
	}
	public List<Post> submitPost(Post post){
		PivnyStvrtok ps = repository.findCurrent().get(0);
		ps.getPosts().add(post);
		repository.save(ps);
		return ps.getPosts();
	}
}
