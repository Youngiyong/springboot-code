package com.service.contents.service;

import com.service.contents.dto.RequestDto;
import com.service.contents.entity.PostCommentEntity;
import com.service.contents.entity.PostEntity;
import com.service.contents.repository.PostCommentRepository;
import com.service.contents.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl {

    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostCommentRepository postCommentRepository) {
        this.postRepository = postRepository;
        this.postCommentRepository = postCommentRepository;
    }

    public PostEntity get(UUID postId) {
        return postRepository.getOne(postId);
    }

    public List<PostEntity> getAll() {
        return postRepository.findAll();
    }

    public PostEntity save(RequestDto.RequestPost payload, String userId) {
        PostEntity post = PostEntity.builder()
                                    .icon(payload.getIcon())
                                    .user_id(userId)
                                    .name(payload.getName())
                                    .description(payload.getDescription())
                                    .build();
        postRepository.save(post);

        return post;
    }

    public void delete(UUID id, String userId) {
        PostEntity post = postRepository.findByIdAndUserId(id, userId);
        postRepository.delete(post);
    }

    public PostCommentEntity save(RequestDto.RequestPostComment payload, String userId) {
        PostCommentEntity postComment = PostCommentEntity.builder().description(payload.getDescription()).user_id(userId).build();
        postCommentRepository.save(postComment);

        return postComment;
    }
}
