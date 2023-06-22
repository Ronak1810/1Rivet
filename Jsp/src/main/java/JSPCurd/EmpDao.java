package JSPCurd;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import JSPCurd.EmpDao;
import JSPCurd.Emp;

public class EmpDao {
	static Connection con;
	
	public static Connection GetConnection() throws SQLException {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;Database=Employee;encrypt=false","sa","Ronak@123");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	
	public static int AddUser(Emp e) {
		int status = 0;
		
		try {
			con = EmpDao.GetConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO UserDetails VALUES (?,?,?);");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPassword());
			status = ps.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
		
	}
	
	public static List<Emp> getAllUsers() throws SQLException {

		List<Emp> list = new ArrayList<Emp>();

		con = EmpDao.GetConnection();
		try {
			PreparedStatement ps1 = con.prepareStatement("SELECT * from UserDetails");

			ResultSet rs = ps1.executeQuery();

			while (rs.next()) {
				Emp e = new Emp(); 
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
	
	
	
	public static int delete(int id) {
		
		int status = 0;
		try {
		Connection con = EmpDao.GetConnection();
		PreparedStatement ps = con.prepareStatement("DELETE from UserDetails WHERE Id="+id);
		//ps.setInt(1,e1.getId());
		status = ps.executeUpdate();		
		con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	
public static int Update(Emp e) {
		
		int status = 0;
		try {
		Connection con = EmpDao.GetConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE UserDetails set Name=?,Email=?,Password=? where Id=?");
		
		 
		ps.setString(1,e.getName());  
        ps.setString(2,e.getEmail());  
        ps.setString(3,e.getPassword());  
        ps.setInt(4,e.getId());

        status = ps.executeUpdate();  
		
		con.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}


public static List<Emp> GetDetails(int Id){
	
	int status = 0;
	List<Emp> list = new ArrayList<Emp>();
	Emp e = new Emp();
	try {
		con=GetConnection();
		PreparedStatement ps2 = con.prepareStatement("SELECT * from UserDetails WHERE Id="+Id);
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

}
