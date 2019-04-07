package datos;

public class User {
	private int id;
	private String name;
	private String userName;
	private String email;
	
	public User (int id, String userName, String name, String email) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.email = email;
	}
	
	//Getters:
	public int getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	
}