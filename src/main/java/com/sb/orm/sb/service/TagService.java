package com.sb.orm.sb.service;

import com.sb.orm.sb.request.TagRequest;
import com.sb.orm.sb.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface TagService {
    ResponseEntity<APIResponse> registerTag(TagRequest request);
}
