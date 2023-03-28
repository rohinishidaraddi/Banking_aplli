package controller09;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao09.Customerdao;
import dto09.Customer;
@WebServlet("/customersignup")
public class Customersignup extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	Customerdao dao=new Customerdao();
	//	String name=req.getParameter("name");
	//String mob=req.getParameter("mob");	
	//String pwd=req.getParameter("pwd");
	String email=req.getParameter("email");
	long mob=Long.parseLong(req.getParameter("mob"));
	//String gnd=req.getParameter("gnd");
	String dob=req.getParameter("dob");
//	resp.getWriter().print("<h1>"+name+"</h1>"
//	       + "<h1>"+mob+"</h1>"
//		+	"<h1>"+pwd+"</h1>"
//			+"<h1>"+email+"</h1>"
//			+"<h1>"+gnd+"</h1>"
//	  	+	"<h1>"+dob+"</h1>");
	Date date=Date.valueOf(req.getParameter("dob"));
	int age=Period.between(date.toLocalDate(),LocalDate.now()).getYears();
	if(age<18){
		resp.getWriter().print("<h1>you have to be 18+ to create a bank Account</h1>");
		req.getRequestDispatcher("SignUp.html").include(req, resp);
	}
	else{
		if(dao.check(mob).isEmpty()&&dao.check(email).isEmpty()){
		Customer customer=new Customer();
		customer.setName(req.getParameter("name"));
		customer.setGender(req.getParameter("gnd"));
		customer.setPwd(req.getParameter("pwd"));
		customer.setEmail(req.getParameter("email"));
		customer.setDob(dob);
		customer.setMob(mob);
		dao.save(customer);
		Customer customer2=dao.check(email).get(0);
		resp.getWriter().print("<h1>Account created successfully</h1>");
		if(customer2.getGender().equals("male"))
			resp.getWriter().print("<h1>Hello sir</h1>");
		else
		resp.getWriter().print("<h1>Hello mam</h1>");
		resp.getWriter().print("<h1>your customer id is: "+customer2.getCust_id()+"</h1>");
		req.getRequestDispatcher("Home.html").include(req, resp);

		}else{
		resp.getWriter().print("<h1>Email or Mobile number already Exists</h1>");
		req.getRequestDispatcher("SignUp.html").include(req, resp);
	}
	}
}
}







