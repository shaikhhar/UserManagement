package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import db.dbConn;
import model.User;

public class UserDaoImpl implements UserDao {
	Connection con = dbConn.getCon();

	@Override
	public List<User> getAll() {
		List<User> ulist = new ArrayList<>();

		String sql = "select * from users";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setFirstName(rs.getString("FirstName"));
				u.setLastName(rs.getString("LastName"));
				u.setEmail(rs.getString("Email"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				ulist.add(u);

			}
			return ulist;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addUser(User u) {
		String sql = "insert into users values(?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, u.getFirstName());
			pstm.setString(2, u.getLastName());
			pstm.setString(3, u.getEmail());
			pstm.setString(4, u.getUsername());
			pstm.setString(5, u.getPassword());

			pstm.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean userValidate(String un, String pw) {
		String sql = "select * from users where username = '" + un + "' and password ='" + pw + "';";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean userExists(String un) {
		String sql = "select * from users where username = '" + un+"';";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getByUn(String un) {
		User u = new User();
		String sql = "select * from users where username = '" + un + "';";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				u.setFirstName(rs.getString("FirstName"));
				u.setLastName(rs.getString("LastName"));
				u.setEmail(rs.getString("Email"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return u;
	}

	@Override
	public boolean updateUser(User u) {
		
		String sql = "update users set FirstName=?, LastName=?, Email=?, password=? where username= '"+u.getUsername()+"';";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, u.getFirstName());
			pstm.setString(2, u.getLastName());
			pstm.setString(3, u.getEmail());
			pstm.setString(4, u.getPassword());
			pstm.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean deleteUser(String un) {
		String sql="delete from users where username='"+un+"';";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
