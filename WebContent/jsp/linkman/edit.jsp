﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加联系人</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/linkMan_updateLinkMan"
		method=post>
		<input type="hidden" name="lkm_id" value="${lkm_id }"/>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						 height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 修改联系人</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>所属客户：</td>
								<td>
								<!-- 遍历root栈中的customerList -->
								<s:select name="customer.cust_id" list="customerList" headerKey="" headerValue="--请选择--" listKey="cust_id" listValue="cust_name" ></s:select>
								</td>
							</tr>
							<TR>
								<td>联系人名称：</td>
								<td>
								<s:textfield cssClass="textbox" id="sChannel2" cssStyle="WIDTH: 180px" maxLength="50" name="lkm_name" />
								</td>
								<td>联系人性别：</td>
								<td>
								<s:radio name="lkm_gender" list="#{'1':'男','0':'女' }"></s:radio>
								</td>
							</TR>
							<TR>
								<td>联系人办公电话 ：</td>
								<td>
								<s:textfield cssClass="textbox" id="sChannel2" cssStyle="WIDTH: 180px" maxLength="50" name="lkm_phone" />
								</td>
								<td>联系人手机 ：</td>
								<td>
								<s:textfield cssClass="textbox" id="sChannel2" cssStyle="WIDTH: 180px" maxLength="50" name="lkm_mobile" />
								</td>
							</TR>
							<TR>
								<td>邮箱 ：</td>
								<td>
								<s:textfield name="lkm_email" cssClass="textbox" cssStyle="WIDTH: 180px" maxLength="50"/>
								</td>
								<td>QQ：</td>
								<td>
								<s:textfield name="lkm_qq" cssClass="textbox" cssStyle="WIDTH: 180px" maxLength="50"/>
								</td>
							</TR>
							<TR>
								<td>职位：</td>
								<td>
								<s:textfield name="lkm_position" cssClass="textbox" cssStyle="WIDTH: 180px" maxLength="50"/>
								</td>
								<td>备注：</td>
								<td>
									<s:textarea name="lkm_memo" cols="20" rows="2" />
								</td>
							</TR>
							<TR>
								<td>爱好：</td>
								<td colspan="3">
								<!-- 将出值栈中取得的lkm_hobby字符串转换为数组，供s标签解析 -->
									<s:checkboxlist list="{'eat','sleep','work'}" name="lkm_hobby" value="%{lkm_hobby}.split(', ')"/>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
