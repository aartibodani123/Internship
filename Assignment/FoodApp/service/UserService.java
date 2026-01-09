package Assignment.FoodApp.service;

import java.util.HashMap;
import Assignment.FoodApp.Exception.*;
import Assignment.FoodApp.UserApp.User;
import Assignment.FoodApp.UserApp.UserAccount;

public class UserService {

    private static HashMap<String, UserAccount> users = new HashMap<>();

    public static void signUp(String email, String password, User user) {
        if (users.containsKey(email)) {
            throw new UserAlreadyExistsException("User already exists with this email");
        }
        users.put(email, new UserAccount(email, password, user));
    }

    public static User signIn(String email, String password) {
        UserAccount account = users.get(email);

        if (account == null) {
            throw new InvalidCredentialsException("User not found");
        }
        if (!account.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid password");
        }
        return account.getUser();
    }
}
