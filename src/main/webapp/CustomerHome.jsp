<%@page import="Online.CustomerBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center> <h1>
<% 
CustomerBean cbean=(CustomerBean)session.getAttribute("cbean");
out.println("Welcome Mr. "+cbean.getFname()+"!!!<br><br>");

%>
<a href="CustomerRegistration.html">Add Customer</a><br><br>
<a href="view1">View details</a><br><br>
<a href="logout">Logout</a><br><br>


</body>
</html>