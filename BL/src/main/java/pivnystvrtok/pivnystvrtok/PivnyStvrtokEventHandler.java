package pivnystvrtok.pivnystvrtok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class PivnyStvrtokEventHandler {
	@Autowired
	PivnyStvrtokService service;
	
	@OnTransition(target = "VOTING")
    void toVoting() {
    }

    @OnTransition(target = "VOTED")
    void toVoted() {
    }
    
    @OnTransition(target = "FINISHED")
    void toFinished() {
    }
}
