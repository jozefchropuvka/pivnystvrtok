package pivnystvrtok.pivnystvrtok;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pivnystvrtok.common.BaseService;
import pivnystvrtok.statemachine.States;
import pivnystvrtok.user.CurrentUserDetailsService;

@Service
public class PivnyStvrtokService extends BaseService<PivnyStvrtok>{
	@Autowired
	public PivnyStvrtokRepository pivnyStvrtokRepository;	
	
	
/*	
	public Vote getVote(){
		PivnyStvrtok ps = pivnyStvrtokRepository.findByState(States.VOTING);
		if(ps == null){
			ps = pivnyStvrtokRepository.findByState(States.VOTED);
		}
		if(ps != null){
			for (Vote vote : ps.getVotes()) {
				if(vote.getUser().getUsername().equals(currentUserService.getUser().getUsername())){
					return vote;
				}
			}
		}
		return null;
	}*/
	
	public PivnyStvrtok create(PivnyStvrtok entity){
		return pivnyStvrtokRepository.save(entity);
	}
	
	public List<DateTime> allowedDates(PivnyStvrtok ps){
		List<DateTime> allowedDates = new ArrayList<>();
		if(ps.getState().equals(States.FINISHED)){
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
