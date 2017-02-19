package pivnystvrtok.pivnystvrtok;

import javax.validation.ValidationException;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pivnystvrtok.ApplicationExceptionCode;

public class PivnyStvrtokValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return PivnyStvrtok.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PivnyStvrtok p = (PivnyStvrtok) target;
		
		if(!p.getDate().dayOfWeek().equals(4)){
			throw new ValidationException(ApplicationExceptionCode.DateIsNotThursday.getMessage());
		}
	}
}
