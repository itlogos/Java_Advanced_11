package ua.lviv.lgs.dto;

public class UserLogin {
	public String userEmail;
	public String destinationUrl;
	
    public UserLogin(String userEmail, String destinationUrl) {
        this.userEmail = userEmail;
        this.destinationUrl = destinationUrl;
    }
}
