package com.itheima.spring.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	
//	  `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
//	  `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
//	  `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
//	  `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
//	  `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
//	  `cust_phone` varchar(64) DEFAULT NULL COMMENT '固定电话',
//	  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '移动电话',
	
	private Long cust_id;
	private String cust_name;
//	private String cust_source;
	private BaseDict baseDictSource;
//	private String cust_industry;
	private BaseDict baseDictIndustry;
//	private String cust_level;
	private BaseDict baseDictLevel;
	private String cust_phone;
	private String cust_mobile;
	//文件真实名
	private String cust_fileName;
	//文件在服务器上的相对路劲
	private String cust_filePath;
	//添加联系人
	private Set<LinkMan> linkMans = new HashSet<LinkMan>();
	
	
	
	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}
	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public BaseDict getBaseDictSource() {
		return baseDictSource;
	}
	public void setBaseDictSource(BaseDict baseDictSource) {
		this.baseDictSource = baseDictSource;
	}
	public BaseDict getBaseDictIndustry() {
		return baseDictIndustry;
	}
	public void setBaseDictIndustry(BaseDict baseDictIndustry) {
		this.baseDictIndustry = baseDictIndustry;
	}
	public BaseDict getBaseDictLevel() {
		return baseDictLevel;
	}
	public void setBaseDictLevel(BaseDict baseDictLevel) {
		this.baseDictLevel = baseDictLevel;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public String getCust_fileName() {
		return cust_fileName;
	}
	public void setCust_fileName(String cust_fileName) {
		this.cust_fileName = cust_fileName;
	}
	public String getCust_filePath() {
		return cust_filePath;
	}
	public void setCust_filePath(String cust_filePath) {
		this.cust_filePath = cust_filePath;
	}
	
}
