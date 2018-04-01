package example.controller;

import example.dao.BlogContentDao;
import example.pojo.blogcontent;
import example.service.BlogContentService;
import example.service.BlogContentServiceImpl;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@Scope("prototype")
@RequestMapping("/user/login")
public class BlogContentController extends HttpServlet{
    @Autowired
    private BlogContentDao blogContentDao;

    //传入JSON
    @RequestMapping(value = "/saveblog", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String jsonTransaction(HttpServletRequest request){
        String mav=new String();
        blogcontent b=new blogcontent();
        b.setBlog(request.getParameter("blog"));
        b.setBlogname(request.getParameter("blogname"));
        b.setKeyword(request.getParameter("keyword"));
        b.setWritername(request.getParameter("writername"));
        System.out.println("blogname:"+request.getParameter("blogname")+"writername:"+request.getParameter("writername")+" keyword:"+request.getParameter("keyword")+" blog:"+request.getParameter("blog"));
        request.setAttribute("info", "JSON server recv");
        int flag = blogContentDao.insertBlogContent(b);
        if(flag==1){
            return "success：保存成功！！！";
        }else{
            return "fail：保存失败！！！";
        }
    }
}
