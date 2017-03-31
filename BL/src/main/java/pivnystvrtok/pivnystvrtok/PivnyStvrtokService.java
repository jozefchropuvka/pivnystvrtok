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
		User u = currentUserService.getUser();
		Assert.notNull(u);
		List<Vote> listVotes = ps.getVotes();	
		if(listVotes.contains(u.getId())){
			for (Vote v : listVotes) {
				if(v.getUser().equals(u)){
					v.setDateVoted(new DateTime());
					v.setDate(vote.getDate());
					v.setRestaurant(vote.getRestaurant());
				}
			}
		} else {
			vote.setUser(u);
			vote.setDateVoted(new DateTime());
			listVotes.add(vote);
		}
		repository.save(ps);
		return vote;
	}

	public Vote getVote() {
		Vote vote = new Vote();
		PivnyStvrtok ps = repository.findCurrent().get(0);
		Assert.notNull(ps);
		User u = currentUserService.getUser();
		Assert.notNull(u);
		List<Vote> listVotes = ps.getVotes();
		Assert.notNull(listVotes);
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
