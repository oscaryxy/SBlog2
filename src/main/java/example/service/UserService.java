package example.service;


import example.pojo.User;
import example.pojo.Usertwo;

import java.util.List;

public interface UserService {
    List<Usertwo> getAllUser();
    public boolean login(String username, String password);
}
