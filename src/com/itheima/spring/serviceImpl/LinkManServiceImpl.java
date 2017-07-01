package com.itheima.spring.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.itheima.spring.dao.LinkManDAO;
import com.itheima.spring.domain.Customer;
import com.itheima.spring.domain.LinkMan;
import com.itheima.spring.domain.Pagination;
import com.itheima.spring.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDAO linkManDAO;

	public void setLinkManDAO(LinkManDAO linkManDAO) {
		this.linkManDAO = linkManDAO;
	}

	@Override
	public void saveLinkMan(LinkMan linkMan) {
		// 保存修改用户
		linkManDAO.saveLinkMan(linkMan);

	}

	@Override
	public void findAll(Pagination<LinkMan> pagination) {
		// 分页查询数据
		// 查询数据总条数
		Long totalCount = linkManDAO.findTotalCount();
		// 计算总页面数
		int totalPage = (int) Math.ceil(totalCount / pagination.getPageSize()) + 1;
		Map<String, String[]> parameterMap = pagination.getParameterMap();
		String lkm_name = parameterMap.get("lkm_name") == null ? null : parameterMap.get("lkm_name")[0];
		String lkm_gender = parameterMap.get("lkm_gender") == null ? null : parameterMap.get("lkm_gender")[0];
		// 查询当前页面客户信息
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		if (StringUtils.isNotBlank(lkm_name)) {
			criteria.add(Restrictions.like("lkm_name", lkm_name, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(lkm_gender)) {
			criteria.add(Restrictions.eq("lkm_gender", lkm_gender));
		}
		// firstResult:起始 maxResults：
		List<LinkMan> linkmans = linkManDAO.findByPage(criteria,
				(pagination.getCurrentPage() - 1) * pagination.getPageSize(),
				pagination.getCurrentPage() * pagination.getPageSize());
		// 封装Pagination
		pagination.setTotalCount(totalCount);
		pagination.setTotalPage(totalPage);
		pagination.setObjects(linkmans);

	}

	@Override
	public LinkMan findLinkManById(Long lkm_id) {
		// 通过ID查询到客户信息
		return linkManDAO.findLinkManById(lkm_id);
	}

	@Override
	public void deleteLinkMan(LinkMan linkMan) {
		linkManDAO.deleteLinkMan(linkMan);

	}

	@Override
	public void updateLinkMan(LinkMan linkMan) {
		// 保存客户
		linkManDAO.updateLinkMan(linkMan);
	}

}
