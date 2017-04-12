package tcrumb.controller;

import tcrumb.model.Comment;
import tcrumb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @RequestMapping(value = "/{blogId}", method = RequestMethod.GET)
    public List<Comment> getAllComments(@PathVariable String blogId) {
        return commentService.getAllComments(blogId);
    }
}
