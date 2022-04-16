package com.service.contents.repository;

import com.service.contents.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository  extends JpaRepository<PostEntity, UUID> {
    PostEntity findByIdAndUserId(UUID id, String name);
}
