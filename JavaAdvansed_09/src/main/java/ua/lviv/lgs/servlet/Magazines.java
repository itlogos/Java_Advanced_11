package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;

@WebServlet("/magazines")
public class Magazines extends HttpServlet {
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Magazine> magazines = magazineService.readAll();
		System.out.println(magazines);
		String json = new Gson().toJson(magazines);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

}
