package pivnystvrtok.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.common.BaseEntity;


public class User extends BaseEntity{

    @JsonProperty
    @NotEmpty
    @Indexed(unique=true) //TODO doesn't work???
    private String username;

    @JsonProperty
    @NotEmpty
    private String password; //hashed

    @JsonProperty
    @NotNull(message="the role is mandatory")
    private Role role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}