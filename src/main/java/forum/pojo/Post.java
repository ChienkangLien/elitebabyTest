package forum.pojo;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private int postId;
    private int userId;
    private String userName;
    private String type;
    private String topic;
    private String content;
    private List<PostImage> imgsInPost;
    private PostImage preview;
    int like;
    LocalDateTime timestamp;

    public Post(int postId, int userId, String userName, String type, String topic, String content, int like, LocalDateTime timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.type = type;
        this.topic = topic;
        this.content = content;
        this.like = like;
        this.timestamp = timestamp;
    }

    public Post(int postId, int userId, String userName, String type, String topic, String content, LocalDateTime timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.type = type;
        this.topic = topic;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Post() {

    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", type='" + type + '\'' +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", like=" + like +
                ", timestamp=" + timestamp +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}




