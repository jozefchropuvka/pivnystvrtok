package pivnystvrtok.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.action.Update;


public class User {

    @Id
    @JsonProperty
    @NotEmpty(groups={Update.class})
    private Long id;

    @JsonProperty
    @NotEmpty
    private String username;

    @JsonProperty
    @NotEmpty
    private String password; //hashed

    @JsonProperty
    @NotNull(message="the role is mandatory")
    private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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