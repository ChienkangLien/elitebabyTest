package forum.dao;

import forum.pojo.Post;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    private String URL = "jdbc:mysql://localhost:3306/tibameproject";
    private String USER = "ian";
    private String PASSWORD = "yi711044";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Post> selectAll() {
        String sql = "select p.*, m.user_name, count(l.like_id) as plike\n" +
                "from post p\n" +
                "         left join post_like l on p.post_id = l.post_id\n" +
                "         join member m on m.USER_ID = p.user_id\n" +
                "group by p.post_id\n" +
                "order by p.post_id desc";
        List<Post> posts = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                posts.add(
                        new Post(
                                rs.getInt("post_id"),
                                rs.getInt("user_id"),
                                rs.getString("user_name"),
                                rs.getString("type"),
                                rs.getString("topic"),
                                rs.getString("content"),
                                rs.getInt("plike"),
                                rs.getObject("time", LocalDateTime.class)
                        ));
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Post> selectPopular() {
        String sql = "select p.*, m.user_name, count(l.like_id) as plike\n" +
                "from post p\n" +
                "         left join post_like l on p.post_id = l.post_id\n" +
                "         join member m on m.USER_ID = p.user_id\n" +
                "group by p.post_id\n" +
                "order by plike desc;";
        List<Post> posts = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                posts.add(
                        new Post(
                                rs.getInt("post_id"),
                                rs.getInt("user_id"),
                                rs.getString("user_name"),
                                rs.getString("type"),
                                rs.getString("topic"),
                                rs.getString("content"),
                                rs.getInt("plike"),
                                rs.getObject("time", LocalDateTime.class)
                        ));
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Post> selectByType(String type) {//String為固定字串
        String sql = "select p.*, m.user_name, count(l.like_id) as plike\n" +
                "from post p\n" +
                "         left join post_like l on p.post_id = l.post_id\n" +
                "         join member m on m.USER_ID = p.user_id\n" +
                "where type = ? \n" +
                "group by p.post_id\n" +
                "order by p.post_id desc;";
        List<Post> posts = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                posts.add(
                        new Post(
                                rs.getInt("post_id"),
                                rs.getInt("user_id"),
                                rs.getString("user_name"),
                                rs.getString("type"),
                                rs.getString("topic"),
                                rs.getString("content"),
                                rs.getInt("plike"),
                                rs.getObject("time", LocalDateTime.class)
                        ));
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Post> selectByTopic(String topic) {//String為模糊字串
        topic = "%" + topic + "%";
        String sql = "select * from post join member m on m.USER_ID = post.user_id where topic like ?;";
        List<Post> posts = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, topic);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                posts.add(
                        new Post(
                                rs.getInt("post_id"),
                                rs.getInt("user_id"),
                                rs.getString("user_name"),
                                rs.getString("type"),
                                rs.getString("topic"),
                                rs.getString("content"),
                                rs.getObject("time", LocalDateTime.class)
                        ));
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int inserInto(Post post) throws SQLException {
        String sql = "insert into post (user_id, type, topic, content) VALUES (?,?,?,?);";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, post.getUserId());
            ps.setString(2, post.getType());
            ps.setString(3, post.getTopic());
            ps.setString(4, post.getContent());
            int rows = ps.executeUpdate();
            System.out.println(rows + "rows inserted");
            return rows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int selectLikeById(Post post) {
        String sql = "select count(*) as plike from post_like where post_id = ? group by post_id;";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, post.getPostId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("plike");
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
//
//    public void deleteByIds(int[] ids) {
//        String sql = "delete from blackhorse.user where user_id in (?"
//                + ",?".repeat(ids.length - 1) + ");";
//        try (PreparedStatement ps = c.prepareStatement(sql)) {
//            for (int i = 0; i < ids.length; i++) {
//                ps.setInt(i + 1, ids[i]);
//            }
//            int rows = ps.executeUpdate();
//            System.out.println(rows + "rows deleted");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public List<User> selectByPage(int page, int rows) {
//        String sql = "select * from user limit ? offset ?;";
//        List<User> users = new ArrayList<>();
//        try (PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setInt(1, rows);
//            ps.setInt(2, (page - 1) * rows);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                users.add(new User(
//                        rs.getInt("user_id"),
//                        rs.getString("user"),
//                        rs.getString("password")
//                ));
//            }
//            return users;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public int dataSize() {
//        String sql = "select count(*) from blackhorse.user;";
//        int counts = 0;
//        try (PreparedStatement ps = c.prepareStatement(sql)) {
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                counts = rs.getInt("count(*)");
//            }
//            return counts;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


