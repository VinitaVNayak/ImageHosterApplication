package ImageHoster.service;

import ImageHoster.model.Comments;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void addComment(Comments comments) {
        commentRepository.addComment(comments);
    }
}
