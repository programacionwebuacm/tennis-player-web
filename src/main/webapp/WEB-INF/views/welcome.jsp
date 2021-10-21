<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tennis Player DB</title>
</head>
<body>

<h2>Welcome (bienvenido) to the tennis players database!</h2>
<h3>Player name: <i>${name}</i> </h3>
<h3>Player last name: <i>${lname}</i> </h3>
<%
System.out.println("Hello from JSP");
%>
<%
LocalDate currentDate = LocalDate.now();
%>
<p>Current Date: <%= currentDate %> </p>
<p>Today is <%= currentDate.getDayOfWeek() %> </p>

<form action="/player.do" method="post">
<b>Player name:</b> <input type="text" name="name"/>
<input type="submit" value="Enter"/>
</form>


</body>
</html>