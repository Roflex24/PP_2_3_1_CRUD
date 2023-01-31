package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUser(int id);
    List<User> getAllUsers();
    User getUser(int id);
    void updateUser(User user);

}
