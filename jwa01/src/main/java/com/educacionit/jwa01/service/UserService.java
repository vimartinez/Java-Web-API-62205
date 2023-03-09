package com.educacionit.jwa01.service;

import java.util.List;

import com.educacionit.jwa01.dao.UserDao;
import com.educacionit.jwa01.model.User;

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

	public Boolean delUser(User user) {
		return userDao.del(user);
		
	}

	public boolean updUser(User user) {
		// 1 voy a ver si el usuario existe, si no existe devuelvo erro no existe el usuario
		// 2 si el usuario existe hago un getUserById
		// 3 comparo campo a campo y actualizo unicamente los datos que se modificaron, si no viene uso el actual
		return userDao.upd(user);
	}

}
