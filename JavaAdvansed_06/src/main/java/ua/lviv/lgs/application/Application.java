package ua.lviv.lgs.application;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.domain.Subscribe;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.SubscribeService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;
import ua.lviv.lgs.service.impl.SubscribeServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;

public class Application {

	public static void main(String[] args) {
		

//		UserService userService = new UserServiceImpl();
		
//		private static final long serialVersionUID = 1L;
		UserService userService = UserServiceImpl.getUserService();

//		protected void doPost(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {

			String email = "3";
			String password = "4";

			User user = userService.getUserByEmail(email);
		
			if (user.getPassword().equals(password)) {
		           System.out.println("Yes");
           System.out.println(user);
			}else {
		           System.out.println("No");
		           System.out.println(user);
			}
//		}
		
		
			
			
			
			
//		userService.create(new User("Oleg", "Tarasenko", "oleg@gmail.com","1","USER"));
//		userService.create(new User("Ivan", "Shup", "ivan@gmail.com","2","USER"));
//		userService.create(new User("Dima", "Crown", "dima@gmail.com","3","ADMIN"));
//		System.out.println("List of users after adding:");
//		userService.readAll().forEach(System.out::println);
//		System.out.println("\nID search result :\n" + userService.read(2) + "\n");
//		userService.update(new User(2, "Peter", "Smith-Brown", "peter_smithBrown@gmail.com", "0000", "USER"));
//		System.out.println("User after update :");
//		userService.readAll().forEach(System.out::println);
//		userService.delete(3);
//		System.out.println("\nList of users after deleting:");
//		userService.readAll().forEach(System.out::println);
//		
//		MagazineService magazineService = new MagazineServiceImpl();
//		magazineService.create(new Magazine("Car", LocalDate.parse("2019-10-22"), 60.99));
//		magazineService.create(new Magazine("Fashion", LocalDate.parse("2022-01-20"), 99.89));
//		magazineService.create(new Magazine("News", LocalDate.parse("2022-12-13"), 53.59));
//		System.out.println("\nList of magazines after adding:");
//		magazineService.readAll().forEach(System.out::println);
//		System.out.println("\nID search result :\n" + magazineService.read(1) + "\n");
//		magazineService.update(new Magazine(2, "Art", LocalDate.parse("2018-07-07"), 177.89));
//		System.out.println("Magazine after update :");
//		magazineService.readAll().forEach(System.out::println);
//		magazineService.delete(3);
//		System.out.println("\nList of magazines after deleting:");
//		magazineService.readAll().forEach(System.out::println);
//		
//		SubscribeService subscribeService = new SubscribeServiceImpl();
//		subscribeService.create(new Subscribe(1, 1, true, LocalDate.parse("2019-11-20"), 6));
//		subscribeService.create(new Subscribe(2, 2, true, LocalDate.parse("2020-09-13"), 9));
//		System.out.println("\nList of subscribes after adding:");
//		subscribeService.readAll().forEach(System.out::println);
//		System.out.println("\nID search result :\n" + subscribeService.read(1) + "\n");
//		subscribeService.update(new Subscribe(1, 1, 2, true, LocalDate.parse("2020-09-13") , 12));
//		System.out.println("Subscribe after update :");
//		subscribeService.readAll().forEach(System.out::println);
//		subscribeService.delete(1);
//		System.out.println("\nList of subscribes after deleting:");
//		subscribeService.readAll().forEach(System.out::println);
	}
}