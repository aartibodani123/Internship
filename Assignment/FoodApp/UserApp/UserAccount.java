package Assignment.FoodApp.UserApp;


public class UserAccount {

    private String email;
    private String password;
    private User user; // Customer or DeliveryPartner

    public UserAccount(String email, String password, User user) {
        this.email = email;
        this.password = password;
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public User getUser() {
        return user;
    }
}

