package com.itheima.spring.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.spring.dao.UserDAO;
import com.itheima.spring.domain.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	//用户登录
	public User login(String user_code,String user_password){
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_code", user_code));
		criteria.add(Restrictions.eq("user_password", user_password));
		List<User> loginUser = (List<User>) super.getHibernateTemplate().findByCriteria(criteria);
		
		return loginUser.isEmpty()?null:loginUser.get(0);
	}

	@Override
	public User findUserInfo(Long user_id) {
		//用户信息回显
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_id", user_id));
		List<User> userFinded = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		return userFinded.get(0);
	}

	@Override
	public void saveUser(User user) {
		// 保存用户修改信息
		getHibernateTemplate().update(user);
	}

	@Override
	public List<User> findAll() {
		return getHibernateTemplate().loadAll(User.class);
	}

}
