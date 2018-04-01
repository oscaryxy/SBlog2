package example.service;


import example.dao.UserDao;
import example.pojo.User;
import example.pojo.Usertwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userServiceImpl")
@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<Usertwo> getAllUser() {
        return userDao.getAllUsers();
    }
    //下面是实现登陆的服务层代码；
    @Autowired
    UserDao Mapper;
    //登录方法的实现,从jsp页面获取username与password
    public boolean login(String username, String password) {
        User user = Mapper.selectByName(username);
        if (user != null) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    @Override
    public int regist(String username, String password, String name, String word) {
        User auser = new User();
            auser.setPassword(password);
            auser.setUsername(username);
            auser.setName(name);
            auser.setWord(word);
            int ares = userDao.aregist(auser);
            return ares;
    }
}