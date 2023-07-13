package com.minewaku.controller.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minewaku.model.UserModel;
import com.minewaku.service.IUserService;

@WebServlet(urlPatterns = {""})
public class HomeController extends HttpServlet {

	@Inject
	private IUserService userService;
	
	private static final long serialVersionUID = -2161442152698563444L;
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UserModel model = new UserModel();
//		model.setRoleId(1);
//		model.setUsername("minewaku");
//		model.setPhone("1234567890");
//		model.setPassword("admin");
//		model.setBirthday(new Date(System.currentTimeMillis()));
//		model.setGender("male");
//		model.setStatus(true);
//		model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//		model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
//		model.setCreatedBy(1);
//		model.setModifiedBy(1);
//		userService.save(model);
//		request.setAttribute("users", userService.findAll());
//		RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
//		rd.forward(request, response);
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
		rd.forward(request, response);
	}

}
