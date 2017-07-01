<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form method="post" action="user_saveUser" >
	<s:hidden name="user_id" /><br>
	<s:textfield name="user_code" ></s:textfield><br>
	<s:textfield name="user_name" ></s:textfield><br>
	<s:textfield name="user_password" ></s:textfield><br>
	<s:textfield name="user_state" ></s:textfield><br>
	<s:submit value="提交"></s:submit>
</s:form>

</body>
</html>