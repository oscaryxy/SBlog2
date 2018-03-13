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
    //自动注入iuserdao 用于访问数据库
    @Autowired
    UserDao Mapper;

    //登录方法的实现,从jsp页面获取username与password
    public boolean login(String username, String password) {
//  System.out.println("输入的账号:" + username + "输入的密码:" + password);
        //对输入账号进行查询,取出数据库中保存对信息
        User user = Mapper.selectByName(username);
        if (user != null) {
//   System.out.println("查询出来的账号:" + user.getUsername() + "密码:" + user.getPassword());
//   System.out.println("---------");
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;

    }
}