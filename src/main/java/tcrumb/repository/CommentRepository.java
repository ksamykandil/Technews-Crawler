package tcrumb.repository;

import tcrumb.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CommentRepository extends CrudRepository<Comment, String> {
    List<Comment> getByBlogId(String blogId);
}
