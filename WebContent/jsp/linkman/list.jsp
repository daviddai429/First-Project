<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<SCRIPT language=javascript>
	function to_page(currentPage) {
		if (currentPage) {
			$("#currentPage").val(currentPage);
		}
		document.customerForm.submit();

	}
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/linkMan_showLinkMan"
		method=post>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%"
						background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15
						background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg"
						border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>联系人名称：</TD>
													<TD>
													<s:textfield cssClass="textbox" id="sChannel2" cssStyle="WIDTH: 80px" maxLength="50" name="lkm_name"></s:textfield>
													</TD>
													<TD>性别：</TD>
													<TD>
													<s:select name="lkm_gender" list="#{'1':'男','0':'女'}" headerKey="" headerValue="--请选择--"/>
													</TD>

													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
														
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>

								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>联系人名称</TD>
													<TD>所属公司</TD>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator value="#pagination.objects">
													<TR
														style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
														<TD><s:property value="lkm_name" /></TD>
														<td><s:property value="customer.cust_name"/></td>
														<TD>
														<s:if test="lkm_gender==1">男</s:if>
														<s:else>女</s:else>
														</TD>
														<TD><s:property value="lkm_phone" /></TD>
														<TD><s:property value="lkm_mobile" /></TD>
														<TD>
														<s:a action="linkMan_showEdit" namespace="/">
															修改
															<s:param name="lkm_id" value="lkm_id"></s:param>
														</s:a>
														<s:a action="linkMan_deleteLinkMan" namespace="/">
															删除
															<!-- 删除联系人时回传联系人的id -->
															<s:param name="lkm_id" value="lkm_id"></s:param>
														</s:a></TD>
													</TR>
												</s:iterator>

											</TBODY>
										</TABLE>
									</TD>
								</TR>

								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${pagination.totalCount}</B>]条记录,[<B>${pagination.totalPage}</B>]页
												,每页显示 <select name="pageSize">

													<option value="2"
														<s:if test="#pagination.pageSize==2 ">selected</s:if>
														>2</option>
													<option value="10"
														<s:if test="#pagination.pageSize==10 ">
														selected
													</s:if>>10</option>
												</select> 条
												<s:if test="#pagination.currentPage>1">
												[<A href="javascript:to_page(${pagination.currentPage-1})">前一页</A>]
												</s:if>
												<B>${pagination.currentPage}</B>
												<s:if test="#pagination.currentPage<#pagination.totalPage">
												[<A href="javascript:to_page(${pagination.currentPage+1})">后一页</A>] 
												</s:if>
												到 <input type="text" size="3" id="currentPage"
													name="currentPage" /> 页 <input type="button" value="Go"
													onclick="to_page()" />
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
	</FORM>
</BODY>
</HTML>
