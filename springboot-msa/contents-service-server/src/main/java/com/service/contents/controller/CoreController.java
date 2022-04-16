package com.service.contents.controller;


import com.service.contents.dto.RequestDto;
import com.service.contents.dto.ResponseDto;
import com.service.contents.entity.PostEntity;
import com.service.contents.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
@RefreshScope
public class CoreController {


    @Value("${server.port}")
    private int port;

    @Value("HI")
    private String message;

    @Autowired
    private PostServiceImpl postService;

    @GetMapping("/contents/detail")
    public String contents() {
        return "Contents Detail - Port " + port + " - " + message;
    }

    @GetMapping("/pay/detail")
    public String pay() {
        return "Pay Detail - Port " + port + " - " + message;
    }

    @GetMapping("/comment")
    public String comment() {
        return "Comment - Port " + port + " - " + message;
    }

    @GetMapping("/board")
    public String board() {
        return "Board - Port " + port + " - " + message;
    }

    @PostMapping("/posts")
    public ResponseDto.ResponseCreate createPost(@RequestBody RequestDto.RequestPost payload, @RequestHeader String userId){
        //validation check
        return new ResponseDto.ResponseCreate(postService.save(payload, userId).getId(), 200, "Success");
    }

    @PostMapping("/posts/{id}/comments")
    public ResponseDto.ResponseCreate createPost(@RequestBody RequestDto.RequestPostComment payload, @RequestHeader String userId){
        //validation check
        return new ResponseDto.ResponseCreate(postService.save(payload, userId).getId(), 200, "Success");
    }

    @GetMapping("/posts")
    public List<PostEntity> findAllPosts(){
        return postService.getAll();
    }

    @GetMapping("/posts/{id}")
    public PostEntity getPosts(@PathVariable UUID id){
        return postService.get(id);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseDto.Response deletePost(@PathVariable UUID id, @RequestHeader String userId){
        postService.delete(id, userId);
        return new ResponseDto.Response(200, "Success");
    }
}
