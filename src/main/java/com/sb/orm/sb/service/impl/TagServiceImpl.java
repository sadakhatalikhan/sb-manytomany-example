package com.sb.orm.sb.service.impl;

import com.sb.orm.sb.model.TagModel;
import com.sb.orm.sb.repository.TagRepository;
import com.sb.orm.sb.request.TagRequest;
import com.sb.orm.sb.response.APIResponse;
import com.sb.orm.sb.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public ResponseEntity<APIResponse> registerTag(TagRequest request) {
        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(0)
                        .errorMessage("Success")
                        .data(tagRepository.save(TagModel.builder().tagName(request.getTageName()).build()))
                        .build()
        );
    }
}
