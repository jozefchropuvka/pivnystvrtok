package pivnystvrtok.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.web.JsonPath;
import org.springframework.data.web.ProjectedPayload;

@ProjectedPayload
public interface UserPayload {

	@JsonPath("$..username")
	@NotEmpty
	String getUsername();

	@JsonPath("$..password")
	@NotEmpty
	String getPassword();
	
	@JsonPath("$..role")
	@NotNull
	Role getRole();
}