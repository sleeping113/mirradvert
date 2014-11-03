<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章列表</title>
</head>
<body>
	<table align="center" width="80%" cellpadding="0" cellspacing="0" border="1" >
		<tr	align="center">
			<td width="20%">编号</td>
			<td width="50%">书名</td>
			<td width="30%">作者</td>
		</tr>
		<c:forEach items="${articles }" var="article">
			<tr>
				<td>${article.id }</td>
				<td>${article.title }</td>
				<td>${article.author }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>