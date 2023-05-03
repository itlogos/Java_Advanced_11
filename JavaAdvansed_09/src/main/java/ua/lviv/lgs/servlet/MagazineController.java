package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;

@WebServlet("/magazine")
public class MagazineController extends HttpServlet {


	MagazineService magazineService = MagazineServiceImpl.getMagazineService();

	// to create resource (magazine)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		System.out.println(name);
		System.out.println(description);		
		System.out.println(price);
		Magazine magazine  = new Magazine(name, description, getValidatedPrice(price));
		System.out.println(magazine);
		
		magazineService.create(magazine);
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
	private double getValidatedPrice(String price) {
		if(price == null || price.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(price);
	}

	// to get resource (magazine)
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String magazineId = request.getParameter("id");
		
		Magazine magazine = magazineService.read(Integer.parseInt(magazineId));
				
				request.setAttribute("magazine", magazine);
				request.getRequestDispatcher("singleMagazine.jsp").forward(request, response);
	}

	// to update resource (magazine)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPut(req, resp);
	}

	// to delete resource (magazine)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doDelete(req, resp);
	}

}
