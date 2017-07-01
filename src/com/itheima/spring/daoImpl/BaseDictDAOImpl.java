package com.itheima.spring.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.spring.dao.BaseDictDAO;
import com.itheima.spring.domain.BaseDict;

public class BaseDictDAOImpl extends HibernateDaoSupport implements BaseDictDAO{

	public List<BaseDict> listByTypeCode(String dict_type_code){
		DetachedCriteria criteria = DetachedCriteria.forClass(BaseDict.class);
		criteria.add(Restrictions.eq("dict_type_code", dict_type_code));
		List<BaseDict> findByCriteria = (List<BaseDict>) getHibernateTemplate().findByCriteria(criteria);
		return findByCriteria;
	}
	
}
