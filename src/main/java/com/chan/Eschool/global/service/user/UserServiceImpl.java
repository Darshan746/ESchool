package com.chan.Eschool.global.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chan.Eschool.global.dao.UserDao;
import com.chan.Eschool.global.model.Role;
import com.chan.Eschool.global.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public User addUser(User user) {
		
		user.setPassword(getEncryptedPassword(user.getPassword()));
		user.setActive(false);
		
		Role role = new Role();
		role.setId(1);
		user.setRole(role);
		
		return getUserDao().addUser(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserById(long id) {
		return getUserDao().findUserById(id);
	}

	@Override
	@Transactional
	public boolean activateUser(long id) {
		return getUserDao().activateUser(id);
	}

	@Override
	@Transactional
	public boolean deActivateUser(long id) {
		return getUserDao().deActivateUser(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return getUserDao().getAllUsers();
	}

	@Override
	@Transactional
	public boolean deleteUser(long id) {
		return getUserDao().deleteUser(id);
	}

	@Override
	public String getEncryptedPassword(String plainPassword) {
		return BCrypt.hashpw(plainPassword,BCrypt.gensalt());
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean userExists(String email) {
		return getUserDao().userExists(email);
	}
	
	@Override
	@Transactional(readOnly = true)
	public User findUserByEmail(String email) {
		return getUserDao().findUserByEmail(email);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
