package example.controller;


import example.pojo.User;
import example.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//@Controller注解用于标示本类为web层控制组件
@Controller
//@RequestMapping("/user")用于标定访问时对url位置
@RequestMapping("/user")
//在默认情况下springmvc的实例都是单例模式,所以使用scope域将其注解为每次都创建一个新的实例
@Scope("prototype")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Resource
    private UserService service;

    /**
     *返回user对象信息给page1.jsp处理，然后在前端页面展示
     */
     @RequestMapping("/page")
    public ModelAndView getUser() {
        System.out.println("访问page1的后台。。。");
        ModelAndView mav = new ModelAndView("page1");
        List<User> users = service.getAllUser();
        System.out.println(users);
        mav.addObject("user", users.get(0));
        return mav;
//        return "page1"; //跳转到.jsp结尾的对应文件（page1.jsp）,此时返回值是String
    }

    /**
     * 直接返回字符串给请求的页面（这里在请求URL增加参数v是验证前后台通信是否正常）
     * @param request
     * @param response
     * @return
     */

    @RequestMapping(value = "/sql", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String sayHi(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("v");
        List<User> users = service.getAllUser();
        logger.info("{name:yxy,context:hi,你好}");
        return name+"-{name:yxy,context:hi,你好}"+users;
    }






        //自动注入业务层的userService类
        @Autowired
        UserService userService;

        //login业务的访问位置为/user/login
        @RequestMapping("/login")
        public String login(User user,HttpServletRequest request){
            //调用login方法来验证是否是注册用户
            boolean loginType = userService.login(user.getUsername(),user.getPassword());
            if(loginType){
                //如果验证通过,则将用户信息传到前台
                request.setAttribute("user",user);
                //并跳转到success.jsp页面
                return "dlcg";
            }else{
                //若不对,则将错误信息显示到错误页面
                request.setAttribute("message","用户名密码错误");
                return "dlsb";
            }
        }
}
