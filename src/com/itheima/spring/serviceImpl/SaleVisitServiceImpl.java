package com.itheima.spring.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itheima.spring.dao.SaleVisitDAO;
import com.itheima.spring.domain.Customer;
import com.itheima.spring.domain.Pagination;
import com.itheima.spring.domain.SaleVisit;
import com.itheima.spring.service.SaleVisitService;

public class SaleVisitServiceImpl implements SaleVisitService {
	private SaleVisitDAO saleVisitDAO;

	public void setSaleVisitDAO(SaleVisitDAO saleVisitDAO) {
		this.saleVisitDAO = saleVisitDAO;
	}

	@Override
	public void findAll(Pagination<SaleVisit> pagination) {
		// 分页查询数据
		//查询数据总条数
		Long totalCount = saleVisitDAO.findTotalCount();
		//计算总页面数
		int totalPage = (int) Math.ceil(totalCount/pagination.getPageSize())+1;
		Map<String, String[]> parameterMap = pagination.getParameterMap();
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String visit_time = parameterMap.get("visit_time")==null?null:parameterMap.get("visit_time")[0];
		String visit_end_time = parameterMap.get("visit_end_time")==null?null:parameterMap.get("visit_end_time")[0];
		//查询当前页面客户信息
		DetachedCriteria criteria = DetachedCriteria.forClass(SaleVisit.class);
		if (StringUtils.isNotBlank(visit_time)) {
			try {
				criteria.add(Restrictions.ge("visit_time", dFormat.parse(visit_time)));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("日期类型转换错误");
			}
		}
		if (StringUtils.isNotBlank(visit_end_time)) {
			try {
				criteria.add(Restrictions.le("visit_time", dFormat.parse(visit_end_time)));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("日期类型转换错误");
			}
		}
		//firstResult:起始    maxResults：
		List<SaleVisit> saleVisits = saleVisitDAO.findByPage(criteria, (pagination.getCurrentPage()-1)*pagination.getPageSize(), pagination.getCurrentPage()*pagination.getPageSize());
		//封装Pagination
		pagination.setTotalCount(totalCount);
		pagination.setTotalPage(totalPage);
		pagination.setObjects(saleVisits);
	}

	@Override
	public void save(SaleVisit saleVisit) {
		// 保存新增访问记录
		saleVisitDAO.save(saleVisit);
	}

}
