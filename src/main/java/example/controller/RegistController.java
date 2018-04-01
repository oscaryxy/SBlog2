package example.controller;


import example.dao.UserDao;
import example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


@Controller
@Scope("prototype")
@RequestMapping("/user/login")
public class RegistController extends HttpServlet {
    @Autowired
    private UserDao auserdao;
    @RequestMapping(value = "/regist", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String registcon(HttpServletRequest request){
        String mm=new String();
        User uu=new User();
        uu.setWord(request.getParameter("word"));
        uu.setName(request.getParameter("name"));
        uu.setUsername(request.getParameter("username"));
        uu.setPassword(request.getParameter("password"));
        System.out.println("name:"+request.getParameter("name")+"username:"+request.getParameter("username")+" password:"+request.getParameter("password")+" word:"+request.getParameter("word"));
        request.setAttribute("info","JSON server recv");
        int aflog=auserdao.aregist(uu);
        if(aflog==1){
            return "success：注册成功!";
        }else{
            return "fail：注册失败！";
        }
    }
}
