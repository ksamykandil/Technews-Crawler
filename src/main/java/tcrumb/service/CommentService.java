package tcrumb.service;

import tcrumb.model.Comment;
import tcrumb.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        comment.setCreationDate(new Date());
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments(String blogId) {
        return commentRepository.getByBlogId(blogId);
    }
}
