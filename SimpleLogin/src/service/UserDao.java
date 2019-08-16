package service;

import java.util.List;
import model.User;

public interface UserDao {
	
	List<User> getAll();
	boolean addUser(User u);
	boolean userValidate(String un, String pw);
	boolean userExists(String un);
	User getByUn(String un);
	boolean updateUser(User u);
	boolean deleteUser(String un);

}
