package com.educacionit.jwa01.service;

import java.util.List;

import com.educacionit.jwa01.model.User;

import dao.UserDao;

public class UserService {
	
	UserDao userDao = new UserDao();

	public User getUserById(Long id) {
		return userDao.getById(id);
	}

	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	public Boolean addUser(User user) {
		return userDao.add(user);
		
	}

}
