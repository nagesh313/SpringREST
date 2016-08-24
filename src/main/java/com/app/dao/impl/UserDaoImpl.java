package com.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.app.dao.UserDao;
import com.app.model.User;
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

	
	public void addUser(User user) {
		getSession().save(user);
	}

	
	public void editUser(User user) {
		getSession().update(user);
	}

	
	public void deleteUser(int userId) {
		getSession().delete(findUser(userId));
	}

	
	public User findUser(int userId) {
		return (User) getSession().get(User.class, userId);
	}

	
	public User findUserByName(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));		
		return (User) criteria.uniqueResult();
	}

	
	public List<User> getAllUsers() {
		return getSession().createQuery("from User").list();
	}

}
