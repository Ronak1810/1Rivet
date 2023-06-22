package JSPCurd;

public class Emp {
	private String Name, Password, Email;
	private int Id;

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	@Override
	public String toString() {
		return "Emp [Name=" + Name + ", Password=" + Password + ", Email=" + Email + ", Id=" + Id + "]";
	}
	public Emp(String name, String password, String email, int id) {
		super();
		Name = name;
		Password = password;
		Email = email;
		Id = id;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
