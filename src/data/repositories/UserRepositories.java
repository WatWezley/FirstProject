package data.repositories;

import data.models.User;

import java.util.List;

public interface UserRepositories {

    User save(User user);

    User findById(int id);


    User findByUserName(String userName);

    long count();

    List<User> findAll();

    void delete(int id);

    void delete(User user);

    void deleteAll();




}
