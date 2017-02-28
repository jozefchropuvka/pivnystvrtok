package pivnystvrtok.pivnystvrtok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import org.springframework.util.Assert;
import pivnystvrtok.ApplicationExceptionCode;

@Component("beforeSavePivnyStvrtokValidatorUpdate")
public class PivnyStvrtokValidatorUpdate implements Validator {

	@Autowired
	PivnyStvrtokRepository repo;

	@Override
	public boolean supports(Class<?> clazz) {
		return PivnyStvrtok.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PivnyStvrtok p = (PivnyStvrtok) target;
		if (repo.findCurrent().size() > 1) {
			errors.reject(ApplicationExceptionCode.StateIsNotFinished.getMessage());
		}
		Assert.notNull(p.getDate());
		Assert.notNull(p.getRestaurant());
		Assert.notNull(p.getState());
		if (p.getDate().dayOfWeek().get() != 4) {
			errors.rejectValue("date", ApplicationExceptionCode.DateIsNotThursday.getMessage());
		}
	}
}
