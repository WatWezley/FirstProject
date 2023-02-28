package controllers;

import dto.requests.RegisterRequest;
import services.UserServiceImpl;
import services.UserServices;

public class UserController {

    private UserServices userService = new UserServiceImpl();

    public Object register(RegisterRequest request) {
        try {
            return userService.register(request);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }


    public Object findUserById(int userId) {
        try {
            return userService.findUser(userId);
        } catch (NullPointerException ex) {
            return ex.getMessage();
        }
    }
}


