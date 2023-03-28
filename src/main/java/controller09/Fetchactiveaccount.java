package controller09;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto09.BankAccount;
import dto09.Customer;

@WebServlet("/fetchactiveaccount")
public class Fetchactiveaccount extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer=(Customer) req.getSession().getAttribute("customer");
		
		if(customer==null){
			res.getWriter().print("<h1>session Expired Login again</h1>");
			req.getRequestDispatcher("Login.html");
		}else{
		List<BankAccount> list=customer.getAccounts();
		List<BankAccount>list2=new ArrayList<BankAccount>();
		
		for(BankAccount account:list)
		{
			if(account.isStatus()){
				list2.add(account);
				}
		}
		req.setAttribute("list", list2);
		req.getRequestDispatcher("Account.jsp").include(req, res);
	}
	}
}
