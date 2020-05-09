package Spring.Rest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {

	int id;
	String username;
	String firstName;
	String lastName;
	String email;
	String password;
	String phone;
	int userStatus;

	public User(int id, String userName, String phone, String lastName, String firstName, String email, String password,
			int status) {
		this.id = id;
		this.username = userName;
		this.phone = phone;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userStatus = status;
		this.firstName = firstName;
	}

//	public String getUserName() {
//		return this.username;
//	}
//
//	public void setUserName(String userName) {
//		this.username = userName;
//	}
}
