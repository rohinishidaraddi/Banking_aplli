<%@page import="dto09.BankAccount" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
<% List<BankAccount> list=(List<BankAccount>)request.getAttribute("list"); %>
<table border="1">
<tr>
<th>Account Number</th>
<th>Account type</th>
<th>Customer Name</th>
<th>Customer Id</th>
<th>status</th>
<th>change Status</th>
</tr>
<% for (BankAccount account:list){ %>

<tr>
<th><%=account.getAcno() %></th>
<th><%=account.getType() %></th>
<th><%=account.getCustomer().getName() %></th>
<th><%=account.getCustomer().getCust_id() %></th>
<th><%=account.isStatus() %></th>
<th><a href="changestatus?acno=<%=account.getAcno() %>"><button>change Status</button></a></th>

</tr>

 <%} %>
 



</table>
<br><br>
<a href="Home.html"><button>logout</button></a>
</body>
</html>