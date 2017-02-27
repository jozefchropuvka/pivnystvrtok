package pivnystvrtok.pivnystvrtok;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pivnystvrtok.ApplicationExceptionCode;

@Component("beforeCreatePivnyStvrtokValidatorCreate")
public class PivnyStvrtokValidatorCreate implements Validator{

	@Autowired
	PivnyStvrtokRepository repo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return PivnyStvrtok.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PivnyStvrtok p = (PivnyStvrtok) target;
		if(!repo.findCurrent().isEmpty()){
			throw new ValidationException(ApplicationExceptionCode.StateIsNotFinished.getMessage());
		}
		if(!p.getDate().dayOfWeek().equals(4)){
			throw new ValidationException(ApplicationExceptionCode.DateIsNotThursday.getMessage());
		}
	}
}
