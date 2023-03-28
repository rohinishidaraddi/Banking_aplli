package controller09;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao09.BankDao;
import dto09.BankAccount;
@WebServlet("/changestatus")
public class changeaccountstatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	  Long acno=Long.parseLong(req.getParameter("acno"));
	    BankDao bankDao=new BankDao();
	    BankAccount account=bankDao.find(acno);
	    
	    if(account.isStatus()) 
	    {
	    	account.setStatus(false);
	    }
	    else {
	    	account.setStatus(true);
	    }
	    
	    bankDao.update(account);
	    res.getWriter().print("<h1>Updated Successfully</h1>");
		req.setAttribute("list", bankDao.fetchAll());
		req.getRequestDispatcher("AdminHome.jsp").include(req, res);
	    }
	}

