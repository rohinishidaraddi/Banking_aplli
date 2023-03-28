package controller09;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao09.BankDao;
import dto09.BankAccount;
@WebServlet("/setaccount")
public class Setaccount extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long acno=Long.parseLong(req.getParameter("acno"));
		BankDao bankdao=new BankDao();
		BankAccount account=bankdao.find(acno);
		req.getSession().setAttribute("acno", acno);
		req.getRequestDispatcher("AccountHome.jsp").include(req, res);
	}

}
