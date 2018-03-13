package example.service;


import example.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    public boolean login(String username, String password);
}
