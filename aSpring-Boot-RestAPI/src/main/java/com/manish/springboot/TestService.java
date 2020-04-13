package com.manish.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	UserDao dao;
	
	String newUser(User user) {
		return dao.newUser(user);
	}
	
	Integer getCountOfUser() {
		return dao.getCountOfUser();
	}
	
	String getUserName(Integer id) {
		return dao.getUserName(id);
	}
	
	List<User> getUserDetails(Integer id) {
		return dao.getUserDetails(id);
	}
	
	List<User> getAllUsers(){
		return dao.getAllUsers();
	}
	
	String updateUserDetails(Integer id, User user) {
		return dao.updateUserDetails(id, user);
	}
	
	String deleteUser(Integer id) {
		return dao.deleteUser(id);
	}
	
}
