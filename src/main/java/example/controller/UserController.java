package example.controller;

import example.pojo.User;
import example.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
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


}
