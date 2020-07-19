package ImageHoster.service;

import org.springframework.beans.factory.annotation.Autowired;

public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    public addComments(Comment comments) {
        commentRepository.addComments(comment);
    }
}
