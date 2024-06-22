package com.sb.orm.sb.controller;

import com.sb.orm.sb.request.PostRequest;
import com.sb.orm.sb.response.APIResponse;
import com.sb.orm.sb.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createPost(@RequestBody PostRequest request) {
        return postService.postMessage(request);
    }

    @GetMapping("/getPosts")
    public ResponseEntity<APIResponse> getPosts() {
        return postService.getPostMessages();
    }
}
