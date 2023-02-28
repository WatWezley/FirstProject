import controllers.UserController;
import dto.requests.RegisterRequest;

import javax.swing.*;
import java.util.jar.JarEntry;

public class Main {

    private static UserController userController = new UserController();
    public static void main(String[] args){
        startApp();

    }

    private static void startApp() {
        String message= """
                Hi
                1--> Register
                2--> Find User
                """;
        String input = input(message);
        switch ((input.charAt(0))){
            case '1' -> register();
            case '2' -> findUser();
            default -> {
                display("Invalid input,try again");
                startApp();
            }
        }


    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    private static void display(String message) {
        JOptionPane.showMessageDialog(null,message);

    }

    private static void findUser() {
        String userInput = input("Enter User ID to search for");
        display(userController.findUserById(Integer.parseInt(userInput)).toString());
        startApp();
    }

    private static void register() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName(input("Enter First Name"));
        request.setLastName(input("Enter Last Name"));
        request.setUserName(input("Enter Username"));
        request.setPassword(input("Enter Password"));
        var result = userController.register(request);
        display(result.toString());
        startApp();
    }




}