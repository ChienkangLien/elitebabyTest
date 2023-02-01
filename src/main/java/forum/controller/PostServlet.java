package forum.controller;

import forum.pojo.Post;
import forum.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/post/*")
public class PostServlet extends BaseServlet {
    private PostService postService = new PostService();

    public void getpost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PostServlet:getpost");
        List<Post> posts = postService.getPost();
//        System.out.println(posts);
        request.setAttribute("posts",posts);
//        String contextPath = request.getContextPath(); //目前空白
        request.getRequestDispatcher("/forum.jsp").forward(request, response);
    }


//    public void topic(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println("post:topic");
//        request.setCharacterEncoding("UTF-8");
//        String p_topic = request.getParameter("topic");
//        System.out.println(p_topic);
//        List<Post> postByTopic = postService.getPostByTopic(p_topic);
//        String s = JSON.toJSONString(postByTopic);
//        response.setContentType("text/json;charset=UTF-8");
//        response.getWriter().write(s);
//    }
}
