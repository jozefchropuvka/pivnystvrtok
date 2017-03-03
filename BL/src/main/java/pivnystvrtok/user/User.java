package pivnystvrtok.user;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.common.BaseDocument;

@Document
public class User extends BaseDocument{

    @JsonProperty
    @Indexed(unique=true) //TODO doesn't work???
    private String username;


    @JsonIgnore
    private String password; //hashed

    @JsonProperty
    private Role role;
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonProperty
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