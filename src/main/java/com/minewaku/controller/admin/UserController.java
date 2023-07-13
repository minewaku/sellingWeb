package com.minewaku.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minewaku.constant.SystemConstant;
import com.minewaku.model.UserModel;
import com.minewaku.service.IUserService;

@WebServlet(urlPatterns = {"admin-user"})
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = -6462688997476631528L;

	@Inject
	private IUserService userService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel model = new UserModel();
		model.setListResult(userService.findAll());
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/list.jsp");
		rd.forward(request, response);
	}
}
