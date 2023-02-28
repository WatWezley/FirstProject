package data.repositories;


import data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoriesImplTest {

    private CommentRepositoriesImpl commentRepositories;

    private Comment comment;
    @BeforeEach
    public void setUp(){
      commentRepositories = new CommentRepositoriesImpl();
      comment = new Comment();
      comment.setUserId(1);
      comment.setPostId(1);
      comment.getTimeStamp();
      comment.setBody("my java story");


    }
    @Test
    public void saveAfterCreation() {
        commentRepositories.save(comment);
        assertEquals(1, commentRepositories.count());
    }

    @Test
    public void saveOneComment_idOfCommentIsOneTest() {
        Comment savedComment = commentRepositories.save(comment);
        assertEquals(1, savedComment.getCommentId());
    }

    @Test
    public void saveTwoCommentWithSameId_countIsOneTest() {
        Comment savedComment = commentRepositories.save(comment);
        assertEquals(1, commentRepositories.count());
        savedComment.setBody("Oga, what are you talking about");
        commentRepositories.save(savedComment);
        assertEquals(1, commentRepositories.count());
    }

    @Test
    public void saveOneComment_findByCommentIdTest() {
        Comment savedComment = commentRepositories.save(comment);
        assertEquals(1, savedComment.getCommentId());
        Comment foundComment = commentRepositories.findById(1);
        assertEquals(foundComment, savedComment);
    }

    @Test
    public void saveOneComment_deleteOneComment_CountIsZeroTest() {
        Comment savedComment = commentRepositories.save(comment);
        assertEquals(1, commentRepositories.count());
        commentRepositories.delete(1);
        assertEquals(0, commentRepositories.count());
    }

    @Test
    public void saveTwoComment_deleteOneComment_byComment() {
        Comment savedComment = commentRepositories.save(comment);
        assertEquals(1, commentRepositories.count());
        Comment comment1 = new Comment();
        comment1.getTimeStamp();
        comment1.setBody("thank you pain, thank you for gain");
        comment1.setUserId(2);
        comment1.setPostId(2);
        Comment savedComment2 = commentRepositories.save(comment1);
        assertEquals(2, commentRepositories.count());
        commentRepositories.delete(savedComment);
        assertEquals(1, commentRepositories.count());
    }

    @Test
    public void saveTwoComment_findAllComment() {
        Comment savedComment = commentRepositories.save(comment);
        Comment comment1 = new Comment();
        comment1.getTimeStamp();
        comment1.setBody("thank you pain, thank you for gain");
        comment1.setPostId(2);
        comment1.setUserId(2);
        Comment savedComment2 = commentRepositories.save(comment1);
        assertEquals(2, savedComment2.getCommentId());
        List<Comment> comments = List.of(new Comment[]{savedComment, savedComment2});
        assertEquals(comments, commentRepositories.findAll());
        assertEquals(2, commentRepositories.count());
    }


    @Test
    public void saveTwoComment_deleteAllComment_CountIsZeroTest () {
        Comment savedComment = commentRepositories.save(comment);
        assertEquals(1, commentRepositories.count());
        Comment comment1 = new Comment();
        comment1.getTimeStamp();
        comment1.setBody("thank you pain, thank you for gain");
        comment1.setUserId(2);
        Comment savedComment2 = commentRepositories.save(comment1);
        assertEquals(1, savedComment.getCommentId());
        assertEquals(2, savedComment2.getCommentId());
        Comment foundComment = commentRepositories.findById(2);
        assertEquals(savedComment2, foundComment);
        assertEquals(2, commentRepositories.count());
        commentRepositories.deleteAll();
        assertEquals(0, commentRepositories.count());
    }
}

