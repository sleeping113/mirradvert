<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<form action="user/login.do" method="post">
		<table align="center" cellpadding="0" cellspacing="0" border="1" width="30%">
			<tr>
				<td>账号</td>
				<td width="60%"><input type="text" name="account"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="login"/></td>
			</tr>
		</table>
	</form>
	<hr>
	<%-- <form:form commandName="user" action="login.do">
		<table align="center" cellpadding="0" cellspacing="0" border="1" width="30%">
			<tr>
				<td>
					<form:label path="account">账号</form:label>
				</td>
				<td width="60%">
					<form:input path="account"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="password">密码</form:label>
				</td>
				<td>
					<form:password path="password"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="登录"/>
				</td>
			</tr>	
		</table>
	</form:form> --%>
</body>
</html>