package pivnystvrtok.pivnystvrtok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pivnystvrtok.user.CurrentUserDetailsService;

@Service
public class PivnyStvrtokService {
	@Autowired
	PivnyStvrtokRepository pivnyStvrtokRepository;
	
	@Autowired
	CurrentUserDetailsService currentUserService;
	
	public PivnyStvrtokSimple getSimpleCurrent(){
		PivnyStvrtokSimple simple = (PivnyStvrtokSimple) pivnyStvrtokRepository.findByState(States.VOTED);
		if( simple == null){
			simple = (PivnyStvrtokSimple) pivnyStvrtokRepository.findByState(States.VOTING);
		}
		return simple;

	}
	
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
	}
	
	public PivnyStvrtok create(PivnyStvrtok entity){
		return pivnyStvrtokRepository.save(entity);
	}
}
