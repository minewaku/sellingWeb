package com.minewaku.api.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minewaku.model.UserModel;
import com.minewaku.service.IUserService;
import com.minewaku.ultis.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-user"})
public class UserAPI extends HttpServlet {

	@Inject
	private IUserService userService;
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UserModel model = HttpUtil.of(request.getReader()).toModel(UserModel.class);
		model = userService.save(model);
		mapper.writeValue(response.getOutputStream(), model);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UserModel model = HttpUtil.of(request.getReader()).toModel(UserModel.class);
		model = userService.update(model);
		mapper.writeValue(response.getOutputStream(), model);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UserModel model = HttpUtil.of(request.getReader()).toModel(UserModel.class);
		userService.delete(model.getIds());
		mapper.writeValue(response.getOutputStream(), model);
	}
}