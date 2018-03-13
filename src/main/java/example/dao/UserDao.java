package example.dao;


import example.pojo.User;


import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    //这里以接口形式定义了数据库操作方法,我们只需在Mybatis映射文件中对其进行映射就可以直接使用
    public User selectByName(String username);
}
