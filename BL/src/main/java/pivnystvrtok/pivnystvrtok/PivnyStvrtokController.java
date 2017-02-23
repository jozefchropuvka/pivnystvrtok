package pivnystvrtok.pivnystvrtok;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/pivnyStvrtok"})
@ResponseBody
public class PivnyStvrtokController {
	
	@Autowired
	PivnyStvrtokService psService;
	
	@Autowired
	StateMachine<States, Events> stateMachine;

	
	@GetMapping("/simple")
	public PivnyStvrtokSimple getSimpleCurrentPivnyStvrtok(){
		return psService.getSimpleCurrent();
	}
	
	@GetMapping("/vote")
	public Vote getVote(){
		return psService.getVote();
	}
	@PostMapping
	public PivnyStvrtok create(@Valid @RequestBody PivnyStvrtok model){
		stateMachine.sendEvent(Events.CREATE);
		return psService.create(model);
	}
}
