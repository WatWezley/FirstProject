package data.models;

import java.time.LocalDateTime;

public class Comment {
    private int commentId;

    private int postId;

    private String body;

    private LocalDateTime timeStamp=LocalDateTime.now();

    private int userId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
