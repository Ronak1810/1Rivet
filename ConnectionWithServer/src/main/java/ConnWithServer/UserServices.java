package ConnWithServer;

import org.apache.catalina.User;

public interface UserServices {
	//Create User
		public void getUser(User user);
		
		//Deposit Money
		public void getAllUsers(User user);
		
		//Withdraw Money
		public void withdrawMoney(long Account_Number);
		
		//get user by id 
		public void getUser(Long Account_Number);
		
		//get all user 
		public void getAllUser(int id);
		
		//delete user by id 
		public void deleteUserById(Long Account_Number);
		
		//update user
		public void updateUserById(long Account_number);

		
}
