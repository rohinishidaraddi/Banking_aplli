package controller09;


import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao09.BankDao;
import dao09.Customerdao;
import dto09.BankAccount;
import dto09.Customer;
@WebServlet("/createbankaccount")
public class CreateBankAccount extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	String banktype = req.getParameter("banktype");

	Customer customer = (Customer) req.getSession().getAttribute("customer");

	List<BankAccount> list = customer.getAccounts();
	boolean flag = true;

	for (BankAccount account : list) {
		if (account.getType().equals(banktype)) {
			flag = false;
			break;
		}
	}

	if (flag) {
		BankAccount account = new BankAccount();

		account.setType(banktype);

		if (banktype.equals("saving"))
			account.setAclimit(10000);
		else
			account.setAclimit(50000);

		account.setCustomer(customer);

		BankDao bankDao = new BankDao();
		bankDao.save(account);

		List<BankAccount> list2 = list;
		list2.add(account);

		customer.setAccounts(list2);

		Customerdao customerDao = new Customerdao();
		customerDao.update(customer);

		res.getWriter().print("<h1>Account Created Successfully</h1>");
	} else {
		res.getWriter().print("<h1>" + banktype + " Account Already Exists</h1>");
		req.getRequestDispatcher("CustomerHome.html").include(req, res);

	}
}
}
