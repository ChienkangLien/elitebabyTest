package forum.service;

import forum.dao.PostDao;
import forum.pojo.Post;

import java.util.List;

public class PostService {
    private PostDao postDao = new PostDao();

    public List<Post> getPost(){
        List<Post> posts = postDao.selectAll();
        return posts;
    }

    public List<Post> getPostByTopic(String topic){
        List<Post> posts = postDao.selectByTopic(topic);
        return posts;
    }




//    public User login(String userName, String password) {
//        return userDao.select(userName, password);
//    }
//
//    public boolean register(String userName, String password) {
//        User user = userDao.selectByName(userName);
//        if (user == null) {
//            userDao.insertInto(userName, password);
//        }
//        return user == null;
//    }
//
//    public boolean ifNameDuplicate(String userName) {
//        User user = userDao.selectByName(userName);
//        if (user != null && userName.length()>0 ) {
//            return true;
//        }
//        return false;
//    }
//
//    public void deleteByIds(int[] ids){
//        userDao.deleteByIds(ids);
//    }
//
//    public PageBean<User> getPageBean(int page, int rows){
//        List<User> users = userDao.selectByPage(page,rows);
//        int dataSize = userDao.dataSize();
//        return new PageBean<>(dataSize,users);
//    }
}


