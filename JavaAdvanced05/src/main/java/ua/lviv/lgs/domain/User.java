package ua.lviv.lgs.domain;

import java.util.Objects;

public class User {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String accessLevel;

	public User(Integer id, String firstName, String lastName, String email, String password, String accessLevel) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accessLevel = accessLevel;
	}

	public User(String firstName, String lastName, String email, String password, String accessLevel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accessLevel = accessLevel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessLevel, email, firstName, id, lastName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(accessLevel, other.accessLevel) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "User id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", email = " + email
				+ ", password = " + password + ", accessLevel = " + accessLevel;
	}

}