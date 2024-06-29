package com.akhm.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.akhm.dao.UserDAO;
import com.akhm.dao.model.UserTl;

public class UserDAOImpl implements UserDAO {
	private HibernateTemplate ht;

	public UserDAOImpl(HibernateTemplate ht) {
		this.ht = ht;
	}

	public Integer insertUser(UserTl userTl) {

		return (Integer) ht.save(userTl);
	}

}
