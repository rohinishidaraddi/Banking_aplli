<%@page import="dto09.Customer"%>
<%@page import="dto09.banktransaction"%>
<%@page import="java.util.List"%>
<%@page import="dto09.BankAccount"%>
<%@page import="dao09.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Transaction</title>+
</head>
<body>

<%Customer customer =(Customer)session.getAttribute("customer"); 
if(customer==null)
{
	response.getWriter().print("<h1>Session Expired Login Again</h1>");
	request.getRequestDispatcher("Login.html").include(request, response);
}
else{
%>
<%
long acno = (Long)request.getSession().getAttribute("acno");
BankDao bankDao = new BankDao();
BankAccount account = bankDao.find(acno);
List<banktransaction> list=account.getTransactions();
%>

<h1>Account Number: <%=acno %></h1><br>
<h1>Account Type: <%=account.getType() %></h1><br>

<table border="1">
<tr>
<th>Transaction_Id</th>
<th>Deposit</th>
<th>Withdraw</th>
<th>Balance</th>
<th>Time</th>
</tr>
<%for(banktransaction transaction:list){ %>
<tr>
<th><%=transaction.getId() %></th>
<th><%=transaction.getDeposit() %></th>
<th><%=transaction.getWithdraw() %></th>
<th><%=transaction.getBalance() %></th>
<th><%=transaction.getDateTime() %></th>
</tr>
<%} %> 
</table>
<br>
<br>
<a href="AccountHome.jsp"><button>Back</button></a>
<%} %>
</body>
</html>