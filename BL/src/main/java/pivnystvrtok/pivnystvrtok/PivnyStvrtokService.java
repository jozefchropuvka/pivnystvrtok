package pivnystvrtok.pivnystvrtok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PivnyStvrtokService {
	@Autowired
	PivnyStvrtokRepository pivnyStvrtokRepository;
	
	public PivnyStvrtokSimple getSimpleCurrent(){
		PivnyStvrtokSimple simple = pivnyStvrtokRepository.findByState(State.VOTED);
		if( simple == null){
			simple = pivnyStvrtokRepository.findByState(State.VOTING);
		}
		return simple;

	}
}
