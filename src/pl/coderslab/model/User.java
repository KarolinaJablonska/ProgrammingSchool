package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {

	private long id;
	private int person_group_id;
	private String username;
	private String email;
	private String password;

	public User() {

	}

	public User(int person_group_id, String username, String email, String password) {
		this.person_group_id = person_group_id;
		this.username = username;
		this.email = email;
		setHashedPassword(password);
	}

	public void setAttributesNoHashed(int person_group_id, String username, String email, String password) {
		this.person_group_id = person_group_id;
		this.username = username;
		this.email = email;
		setPassword(password);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPerson_group_id() {
		return person_group_id;
	}

	public void setPerson_group_id(int person_group_id) {
		this.person_group_id = person_group_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setHashedPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
}