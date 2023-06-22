package ConnWithServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

public class cusDao {

	
	
	static Connection conn;

	public static Connection GetConnection() {
		try {// com.microsoft.sqlserver.jdbc.SQLServerDriver.class
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;Database=Ronak;encrypt=false", "sa",
					"Ronak@123");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	
	
	
	
	public static int save(users e) {
		int status = 0;
		try {
			conn = cusDao.GetConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO customers VALUES(?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPassword());

			status = ps.executeUpdate();
			System.out.println(status);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	
	
	
	

	public static List<users> getAllCustomers() {

		List<users> list = new ArrayList<users>();

		conn = cusDao.GetConnection();
		try {
			PreparedStatement ps1 = conn.prepareStatement("SELECT * from customers");

			ResultSet rs = ps1.executeQuery();

			while (rs.next()) {
				users e = new users();

				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassword(rs.getString(4));
				list.add(e);
				System.out.println(list);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return list;
	}
	
	
	
	
	
	public static List<users> getUserById(int Id){
		
		int status = 0;
		List<users> list = new ArrayList<users>();
		users e = new users();
		try {
			conn=GetConnection();
			PreparedStatement ps2 = conn.prepareStatement("SELECT * from customers WHERE Id="+Id);
			//ps2.setInt(1,Id);  
			ResultSet rs = ps2.executeQuery();
			
			while(rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassword(rs.getString(4));
				
				list.add(e);
				}	
		} 
		catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return list ;	
	}
		
		
		
		
		
		public static List<users> deleteUser(int Id){
			
			int status = 0;
			
			List<users> list = new ArrayList<users>();

			conn = cusDao.GetConnection();
			try {
				PreparedStatement ps1 = conn.prepareStatement("DELETE from customers WHERE Id="+Id);

				ResultSet rs = ps1.executeQuery();

				while (rs.next()) {
					users e = new users();

					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setEmail(rs.getString(3));
					e.setPassword(rs.getString(4));
					list.add(e);
					System.out.println(list);
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return list;
		}
		
		

}
