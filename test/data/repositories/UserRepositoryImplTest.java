package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    private UserRepositoryImpl userRepositories;

    private User user;

    @BeforeEach
    public  void setUp(){
        userRepositories=new UserRepositoryImpl();
        user = new User();
        user.setFirstName("Peace");
        user.setLastName("Hope");
        user.setUserName("PeaceHope");
        user.setPassword("password");
    }

    @Test
    public void saveAfterCreation(){
        userRepositories.save(user);
        assertEquals(1,userRepositories.count());
    }

    @Test
    public void saveOneUser_idOfUserIsOneTest(){
        User savedUser =  userRepositories.save(user);
        assertEquals(1, savedUser.getId());
    }
    @Test
    public void saveTwoUsersWithSameId_countIsOneTest(){
        User savedUser =  userRepositories.save(user);
        assertEquals(1, userRepositories.count());
        savedUser.setLastName("Felix");
        userRepositories.save(savedUser);
        assertEquals(1, userRepositories.count());
    }
    @Test
    public void saveOneUser_findByUserIdTest(){
        User savedUser =  userRepositories.save(user);
        assertEquals(1, savedUser.getId());
        User foundUser = userRepositories.findById(1);
        assertEquals(foundUser, savedUser);
    }
    @Test
    public void saveOneUser_deleteOneUser_CountIsZeroTest(){
        User savedUser =  userRepositories.save(user);
        assertEquals(1, userRepositories.count());
        userRepositories.delete(1);
        assertEquals(0, userRepositories.count());
    }
    @Test
    public void saveTwoUser_deleteOneUser_byUser(){
        User savedUser =  userRepositories.save(user);
        assertEquals(1, userRepositories.count());
        user = new User();
        user.setFirstName("ugo");
        user.setLastName("Hope");
        user.setUserName("ugoHope");
        user.setPassword("password");
        User savedUser2 =  userRepositories.save(user);
        assertEquals(2, userRepositories.count());
        userRepositories.delete(savedUser);
        assertEquals(1, userRepositories.count());
    }

    @Test
    public void saveTwoUser_findAllUser(){
        User savedUser =  userRepositories.save(user);
        user = new User();
        user.setFirstName("ugo");
        user.setLastName("Hope");
        user.setUserName("ugoHope");
        user.setPassword("password");
        User savedUser2 =  userRepositories.save(user);
        assertEquals(2, savedUser2.getId());
         List<User> users2 = List.of(new User[]{savedUser, savedUser2});
        assertEquals(users2,userRepositories.findAll());;
        assertEquals(2, userRepositories.count());
        userRepositories.deleteAll();
        assertEquals(0, userRepositories.count());
    }

    @Test
    public void saveTwoUser_deleteAllUser_CountIsZeroTest(){
        User savedUser =  userRepositories.save(user);
        assertEquals(1, userRepositories.count());
        user = new User();
        user.setFirstName("ugo");
        user.setLastName("Hope");
        user.setUserName("ugoHope");
        user.setPassword("password");
        User savedUser2 =  userRepositories.save(user);
        assertEquals(2, savedUser2.getId());
        User foundUser2 = userRepositories.findById(2);
        assertEquals(foundUser2, savedUser2);
        assertEquals(2, userRepositories.count());
        userRepositories.deleteAll();
        assertEquals(0, userRepositories.count());
    }

}