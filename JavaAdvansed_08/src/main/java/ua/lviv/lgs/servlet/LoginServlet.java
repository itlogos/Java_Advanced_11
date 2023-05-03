package ua.lviv.lgs.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;
import ua.lviv.lgs.dto.UserLogin;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userService.getUserByEmail(email);
	
		if (user != null && user.getPassword().equals(password)) {
			UserLogin userLogin = new UserLogin();
			userLogin.destinationUrl = "cabinet.jsp";
			userLogin.userEmail = user.getEmail();
			String json = new Gson().toJson(userLogin);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}

}
