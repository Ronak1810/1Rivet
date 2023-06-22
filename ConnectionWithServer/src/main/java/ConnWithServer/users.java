package ConnWithServer;

public class users{
	private String Name, Email, Password;
	private int Id;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
	@Override
	public String toString() {
		return "users [Name=" + Name + ", Email=" + Email + ", Password=" + Password + ", Id=" + Id + "]";
	}
	
	
}