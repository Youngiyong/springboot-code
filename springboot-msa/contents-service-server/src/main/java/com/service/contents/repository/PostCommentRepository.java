package com.service.contents.repository;

import com.service.contents.entity.PostCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostCommentRepository  extends JpaRepository<PostCommentEntity, UUID> {
}
