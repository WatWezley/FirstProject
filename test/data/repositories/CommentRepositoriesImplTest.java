package data.repositories;

import data.models.Comment;
import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoriesImplTest {

    private CommentRepositoriesImpl commentRepositories;

    private Comment comment;
    @BeforeEach
    public void setUp(){
      commentRepositories = new CommentRepositoriesImpl();
      comment.setUserId(2);
      comment.setPostId(2);
      comment.getTimeStamp();


    }
    @Test
    public void saveAfterCreation() {
        commentRepositories.save(comment);
        assertEquals(1, commentRepositories.count());
    }


}

