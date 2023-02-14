package data.repositories;

import data.models.Article;
import data.models.Comment;
import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoriesImpl implements CommentRepositories {

    private  int count;

    private List<Comment> comments = new ArrayList<>();

    private Comment comment;

    private User user;


        @Override
        public Comment save(Comment comment) {
        boolean commentIsNotSaved = comment.getCommentId() == 0;
        if(commentIsNotSaved){
            comment.setCommentId(generateCommentId());
            comments.add(comment);
            count++;}
        return comment;
    }

        private int generateCommentId() {
        return count+1;
    }


        @Override
        public Comment findById(int commentId) {
            for (Comment comment : comments) {
                if (comment.getCommentId() == commentId)
                    return comment;
            }
            return null;
        }


        @Override
        public long count() {
        return count;
    }

    @Override
    public List<Comment> findAll() {
        return comments;
    }

    @Override
    public void delete(int commentId) {
        for (Comment comment : comments) {
            if(comment.getCommentId() == commentId) {
               comments.remove(comment);
                count--;
                break;}}
        }

    @Override
    public void delete(Comment comment) {
        for (Comment comment2 : comments) {
            if(comment2 == comment) {
                comments.remove(comment2);
                count--;
                break;}}

    }

    @Override
    public void deleteAll() {
        List<Comment> comments = new ArrayList<>();
        count=0;

    }
}
