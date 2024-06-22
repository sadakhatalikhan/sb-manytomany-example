package com.sb.orm.sb.controller;

import com.sb.orm.sb.request.TagRequest;
import com.sb.orm.sb.response.APIResponse;
import com.sb.orm.sb.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse> registerTag(@RequestBody TagRequest req) {
        return tagService.registerTag(req);
    }
}
