package services;

import data.models.User;
import data.repositories.UserRepositories;
import data.repositories.UserRepositoryImpl;
import dto.requests.RegisterRequest;
import dto.responses.FindUserResponse;
import utils.Mappers;

public class UserServiceImpl implements UserServices{

    UserRepositories userRepositories = new UserRepositoryImpl();
    @Override
    public User register(RegisterRequest registerRequest) {
       if(userExist(registerRequest.getUserName())) throw new IllegalArgumentException(registerRequest.getUserName() + " Already Exist");
       return userRepositories.save(Mappers.map(registerRequest));
        //User user = new User();
       // Mappers.map(registerRequest,user);
        //return userRepositories.save(user);
    }

    private boolean userExist(String userName) {
        User foundUser = userRepositories.findByUserName(userName);
        if (foundUser != null)return  true;
        return  false;
    }

    @Override
    public FindUserResponse findUser(int id) {
        if(userRepositories.findById(id)==null)throw new IllegalArgumentException("USER NOT FOUND");
        User foundUser = userRepositories.findById(id);
        FindUserResponse response= new FindUserResponse();
        Mappers.map(foundUser,response);
        return response;
    }


}
