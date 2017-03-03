package pivnystvrtok.pivnystvrtok;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import pivnystvrtok.ApplicationExceptionCode;
import pivnystvrtok.user.CurrentUserDetailsService;
import pivnystvrtok.user.Role;

@Component
@RepositoryEventHandler(PivnyStvrtok.class)
public class PivnyStvrtokEventHandler {

	@Autowired
	PivnyStvrtokRepository repo;
	
	@Autowired
	CurrentUserDetailsService currentUser;
    
    @HandleBeforeCreate
    public void pivnyStvrtokCreate(PivnyStvrtok ps) throws ValidationException{
		if (!repo.findCurrent().isEmpty()) {
			throw new ValidationException(ApplicationExceptionCode.StateIsNotFinished.getMessage());
		}
		ps.setState(States.VOTING);
		Assert.notNull(ps.getDate());
		Assert.notNull(ps.getRestaurant());
		if (ps.getDate().dayOfWeek().get() != 4) {
			throw new ValidationException(ApplicationExceptionCode.DateIsNotThursday.getMessage());
		}
    }
    
    @HandleBeforeSave
    public void pivnyStvrtokUpdate(PivnyStvrtok ps) throws ValidationException{
    	List<PivnyStvrtok> beforeUpdateList = repo.findCurrent();
		if ( beforeUpdateList.size() > 1) {
			throw new ValidationException(ApplicationExceptionCode.StateIsNotFinished.getMessage());
		}
		Assert.notNull(ps.getState());
		PivnyStvrtok entity = beforeUpdateList.get(0);
		if(!entity.getState().equals(ps.getState()) && !currentUser.getUser().getRole().equals(Role.ROLE_ADMIN)){
			throw new ValidationException(ApplicationExceptionCode.OnlyAdminAllowedChangeState.getMessage());
		}
		Assert.notNull(ps.getDate());
		Assert.notNull(ps.getRestaurant());
		if (ps.getDate().dayOfWeek().get() != 4) {
			throw new ValidationException(ApplicationExceptionCode.DateIsNotThursday.getMessage());
		}
    }
}
