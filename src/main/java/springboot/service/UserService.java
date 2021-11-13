package springboot.service;


import springboot.model.User;

import java.util.List;

public interface UserService {

    void deleteUser(long id);

    void updateUser(User user);

    void createUser(User user);

    List<User> getUsers();

    User getUserById(long id);

    User getUserByName(String name);

    boolean isPasswordChanged (String password, String newPassword);

}
