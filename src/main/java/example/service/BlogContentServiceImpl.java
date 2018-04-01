package example.service;

import example.dao.BlogContentDao;
import example.pojo.blogcontent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("BlogContentService")
public class BlogContentServiceImpl implements BlogContentService {

@Resource
private BlogContentDao blogContentDao;

    public int writeBlog(String blogname,String writename,String keyword,String blog){
        blogcontent content=new blogcontent();
        content.setBlog(blog);
        content.setBlog(blogname);
        content.setBlog(writename);
        content.setBlog(keyword);
        int res=blogContentDao.insertBlogContent(content);
        return res;
    }


}
