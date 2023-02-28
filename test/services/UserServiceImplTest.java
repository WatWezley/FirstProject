package services;

import data.models.User;
import dto.requests.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserServices userServices;
    private RegisterRequest registerRequest;

    User savedUser;

    @BeforeEach
    public  void setUp(){
        userServices = new UserServiceImpl();
        registerRequest = new RegisterRequest();
        registerRequest.setPassword("password");
        registerRequest.setUserName("wezley");
        registerRequest.setFirstName("ugo");
        registerRequest.setLastName("karl");
        savedUser = userServices.register(registerRequest);

    }

    @Test
    public void saveNewUser_IdIsNotZero(){
        assertTrue(savedUser.getId()!=0);
    }

    @Test
    public void duplicateUserNameThrowsException(){
        RegisterRequest request1 = new RegisterRequest();
        request1.setPassword("password2");
        request1.setUserName("wezley");
        request1.setFirstName("ugo2");
        request1.setLastName("karl2");
        assertThrows(IllegalArgumentException.class,()->userServices.register(request1));
    }

    @Test
    public void findUserByIdTest(){
        assertEquals(savedUser.getUserName(),userServices.findUser(1).getUserName());
    }

    @Test
    public void throws_exceptionWhenUserIdIsWrong(){
        assertThrows(NullPointerException.class,()->userServices.findUser(2));
    }

}