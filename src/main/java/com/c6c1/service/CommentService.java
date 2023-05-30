package com.c6c1.service;

import com.c6c1.domain.Comment;
import jakarta.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentService commentRepository;
    @Cacheable(cacheNames = "comment")
    public Comment findById(Long id) {
        Optional<Comment> optional = commentRepository.findById(comment_id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Comment updateComment(Comment comment) {
        commentRepository.updateComment(comment.getAuthor(), comment.getaId());
        return comment;
    }

    public void deleteComment(int comment_id)
    {
        commentRepository.deleteById(comment_id);
    }
}
