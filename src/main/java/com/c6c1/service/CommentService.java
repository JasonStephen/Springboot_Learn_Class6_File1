package com.c6c1.service;

import com.c6c1.domain.Comment;
import com.c6c1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.Optional;



@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    // 根据评论id查询评论信息
//    @Cacheable(cacheNames = "comment")
    @Cacheable(cacheNames = "comment",unless = "#result==null")
    public Comment findById(int comment_id){
        Optional<Comment> optional = commentRepository.findById(comment_id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    // 更新评论信息
    @CachePut(cacheNames = "comment",key = "#result.id")
    public Comment updateComment(Comment comment){
        commentRepository.updateComment(comment.getAuthor(), comment.getaId());
        return comment;
    }
    // 删除评论信息
    @CacheEvict(cacheNames = "comment")
    public void deleteComment(int comment_id){
        commentRepository.deleteById(comment_id);
    }
}
