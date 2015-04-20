package com.chan.Eschool.global.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chan.Eschool.global.model.User;

@Repository
@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User addUser(User user) {
		if(user != null){
			Session session = getSessionFactory().getCurrentSession();
			if(user.getId() == 0){
				session.save(user);
				return user;
			}else if(user.getId() > 0){
				session.update(user);
				return user;
			}
		}
		return null;
	}

	@Override
	public User findUserById(long id) {
		if(id > 0){
			Session session = getSessionFactory().getCurrentSession();
			User user = (User) session.get(User.class, id);
			return user;
		}
		return null;
	}

	@Override
	public boolean activateUser(long id) {
		if(id > 0){
			Session session = getSessionFactory().getCurrentSession();
			/*Query query = session.createQuery("UPDATE User U SET U.active = true WHERE U.id = :id");
			query.setParameter("id", id);
			int row = query.executeUpdate();
			if(row > 0){
				return true;
			}*/
			User user = (User) session.get(User.class, id);
			user.setActive(true);
			session.update(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean deActivateUser(long id) {
		if(id > 0){
			Session session = getSessionFactory().getCurrentSession();
			User user = (User) session.get(User.class, id);
			user.setActive(false);
			session.update(user);
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		Session session = getSessionFactory().getCurrentSession();
		List<User> users = session.createCriteria(User.class).list();
		if(users.size() > 0){
			return users;
		}
		return null;
	}

	@Override
	public boolean deleteUser(long id) {
		if(id > 0){
			Session session = getSessionFactory().getCurrentSession();
			User user = (User) session.get(User.class, id);
			session.delete(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean userExists(String email) {
		if(!email.isEmpty() && email != null){
			
			Session session = getSessionFactory().getCurrentSession();
			Query query = session.createQuery("SELECT U FROM User U WHERE U.email = :email");
			query.setParameter("email", email);
			
			List<User> users = query.list();
			if(users.size() > 0){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public User findUserByEmail(String email) {
		
		if(!email.isEmpty()){
			
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("SELECT U FROM User U WHERE U.email = :email");
			query.setParameter("email", email);
			List<User> users = query.list();
			
			if(users.size() > 0){
				return users.get(0);
			}
		}
		return null;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
