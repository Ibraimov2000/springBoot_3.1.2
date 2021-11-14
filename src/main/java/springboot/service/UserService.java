package springboot.service;

import springboot.model.User;

import java.util.Optional;

public interface UserService {

    void createUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    Iterable<User> getUsers();
    Optional<User> getUserById(Long id);
}
