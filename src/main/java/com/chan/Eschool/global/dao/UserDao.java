package com.chan.Eschool.global.dao;

import java.util.List;

import com.chan.Eschool.global.model.User;

public interface UserDao {

	public User addUser(User user);
	public User findUserById(long id);
	public boolean activateUser(long id);
	public boolean deActivateUser(long id);
	public List<User> getAllUsers();
	public boolean deleteUser(long id);
	public boolean userExists(String email);
	public User findUserByEmail(String email);
}
