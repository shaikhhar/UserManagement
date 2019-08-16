package model;

public class User {
	private String FirstName;
	private String LastName;
	private String email;
	private String username;
	private String password;
	
	public User() {
		
	}
	
	public User(String fn, String ln, String e, String un, String pw) {
		this.FirstName= fn;
		this.LastName= ln;
		this.email= e;
		this.username= un;
		this.password= pw;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
   





}
