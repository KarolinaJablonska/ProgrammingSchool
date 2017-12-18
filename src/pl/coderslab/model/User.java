package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {

	private long id;
	private int person_group_id;
	private String username;

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
		return password;
	}

	private String email;
	private String password;

	public User() {

	}

	public User(int person_group_id, String username, String email, String password) {
		setAttributes(person_group_id, username, email, password);
	}

	public void setAttributes(int person_group_id, String username, String email, String password) {
		this.person_group_id = person_group_id;
		this.username = username;
		this.email = email;
		setPassword(password);
	}

	public void setPassword(String password) {
		String hash = BCrypt.hashpw(password, BCrypt.gensalt());
		this.password = hash;
	}
}