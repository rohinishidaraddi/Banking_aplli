<%@page import="dto09.BankAccount"%>
<%@page import="dao09.BankDao"%>
<%@page import="dto09.Customer" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>checkbalance</title>
</head>
<body><%
long acno=(Long)request.getSession().getAttribute("acno");
	BankDao bankDao=new BankDao();
	BankAccount account=bankDao.find(acno);
	Customer customer=account.getCustomer();
	 %>
	<h1>
	Hello <%if(customer.getGender().equals("male")) %> Mr.<%else{%> Ms.<%} %><%=customer.getName() %></h1>
	<h1>Your <%=account.getType() %> account balance is<%=account.getAmount() %></h1>
	
	<br><br><a href="AccountHome.jsp"><button>back</button></a>
</body>
</html>