package services;

import data.models.User;
import dto.requests.RegisterRequest;
import dto.responses.FindUserResponse;

public interface UserServices {
    User register(RegisterRequest registerRequest);
    FindUserResponse findUser(int id);


}
