package example.service;


import example.pojo.Usertwo;

import java.util.List;

public interface UserService {
    List<Usertwo> getAllUser();
    public boolean login(String username, String password);
    public int regist(String username, String password, String name, String word);
}
