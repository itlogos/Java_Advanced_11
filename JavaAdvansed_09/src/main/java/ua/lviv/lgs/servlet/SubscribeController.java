package ua.lviv.lgs.servlet;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import ua.lviv.lgs.domain.Subscribe;
import ua.lviv.lgs.service.SubscribeService;
import ua.lviv.lgs.service.impl.SubscribeServiceImpl;


@WebServlet("/subscribe")
public class SubscribeController extends HttpServlet {
 
private	SubscribeService subscribeService = SubscribeServiceImpl.getSubscribeService();
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String magazineId = request.getParameter("magazineId");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");

		Subscribe subscribe = new Subscribe(userId, Integer.parseInt(magazineId), new Date());
		subscribeService.create(subscribe);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
