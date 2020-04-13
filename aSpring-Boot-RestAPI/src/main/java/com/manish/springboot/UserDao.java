package com.manish.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String sql;

//	method to add new user to the DB table...
	String newUser(User user) {
		sql = "INSERT INTO users VALUES(?, ?, ?, ?)";
		int success = jdbcTemplate.update(sql,
				new Object[] { user.getId(), user.getName(), user.getPin(), user.getBalance() });
		return (success == 1 ? "User Added Successfully!" : "Failed to add New User! Try Again...!");
	}

//	method to get a count of users in DB table...
	Integer getCountOfUser() {
		sql = "SELECT COUNT(*) FROM users";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

//	method to retrieve the 'user_name' from DB based on the 'user_id'...
	String getUserName(Integer id) {
		sql = "SELECT user_name FROM users WHERE user_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
	}

//	method to retrieve details of a user  from DB based on user_id...
	List<User> getUserDetails(Integer id) {
		sql = "SELECT * FROM users WHERE user_id = ?";

		return jdbcTemplate.query(sql, new Object[] { id }, (rs, rowNum) -> {
			User user = new User();

			user.setId(rs.getInt("user_id"));
			user.setName(rs.getString("user_name"));
			user.setPin(rs.getInt("account_pin"));
			user.setBalance(rs.getDouble("account_balance"));

			return user;
		});
	}

//	method to retrieve details of all the users...
	List<User> getAllUsers() {
		sql = "SELECT * FROM users";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			User user = new User();

			user.setId(rs.getInt("user_id"));
			user.setName(rs.getString("user_name"));
			user.setPin(rs.getInt("account_pin"));
			user.setBalance(rs.getDouble("account_balance"));

			return user;
		});
	}

//	method to update user details based on 'user_id'...
	String updateUserDetails(Integer id, User user) {
		sql = "UPDATE users SET user_name = ?, account_pin = ? WHERE user_id = ? ";
		return (jdbcTemplate.update(sql, new Object[] {user.getName(), user.getPin(), id}) == 1 ? "User Details updated successfully!" : null);
	}

//	method to delete user('s) from DB table...
	String deleteUser(Integer id) {
		sql = "DELETE FROM users WHERE user_id = ?";
		int success = jdbcTemplate.update(sql, new Object[] { id });
		return (success == 1 ? "User Removed Successfully!" : null);
	}

}
