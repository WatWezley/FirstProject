package utils;

import data.models.User;
import dto.requests.RegisterRequest;
import dto.responses.FindUserResponse;

import java.time.format.DateTimeFormatter;

public class Mappers {


    public  static User map(RegisterRequest registerRequest){
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setPassword(registerRequest.getPassword());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        return user;
    }

    public  static void map(RegisterRequest registerRequest,User user) {
        user.setUserName(registerRequest.getUserName());
        user.setPassword(registerRequest.getPassword());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
    }

    public static void map(User foundUser, FindUserResponse response){
        response.setFullName(foundUser.getFirstName()+ " " + foundUser.getLastName());
        response.setUserId(foundUser.getId());
        response.setUserName(foundUser.getUserName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E,dd/MM/yyy, hh:mm a");
        response.setDateRegistered(formatter.format(foundUser.getDateRegistered()));

    }
}
