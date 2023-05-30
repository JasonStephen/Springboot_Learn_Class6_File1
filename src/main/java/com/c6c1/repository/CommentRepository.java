package com.c6c1.repository;

import com.c6c1.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository {
    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET c.content = ?1 WHERE c.id = ?2")
    public int updateComment(String content, Integer id);
}
