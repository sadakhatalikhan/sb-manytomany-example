package com.sb.orm.sb.service.impl;

import com.sb.orm.sb.model.PostModel;
import com.sb.orm.sb.model.TagModel;
import com.sb.orm.sb.repository.PostRepository;
import com.sb.orm.sb.repository.TagRepository;
import com.sb.orm.sb.request.PostRequest;
import com.sb.orm.sb.request.TagRequest;
import com.sb.orm.sb.response.APIResponse;
import com.sb.orm.sb.response.PostResponse;
import com.sb.orm.sb.response.TagResponse;
import com.sb.orm.sb.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final TagRepository tagRepository;
    private final PostRepository postRepository;

    @Override
    public ResponseEntity<APIResponse> postMessage(PostRequest request) {
        // create a postmodel
        PostModel postModel = PostModel.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .tags(tagModelSet(request.getTags()))
                .build();

        PostModel model = postRepository.save(postModel);
        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(0)
                        .errorMessage("success")
                        .data(PostResponse.builder()
                                .title(model.getTitle())
                                .description(model.getDescription())
                                .tags(model.getTags()
                                        .stream()
                                        .map(tagModel -> TagResponse.builder()
                                                .tageName(tagModel.getTagName())
                                                .build())
                                        .collect(Collectors.toSet())
                                )
                                .build()
                        )
                        .build()
        );
    }

    @Override
    public ResponseEntity<APIResponse> getPostMessages() {
        List<PostModel> postModelList = postRepository.findAll();
        Set<PostResponse> responses = postModelList.stream()
                .map(model -> PostResponse.builder()
                        .title(model.getTitle())
                        .description(model.getDescription())
                        .tags(model.getTags().stream()
                                .map(tagModel -> TagResponse.builder()
                                        .tageName(tagModel.getTagName())
                                        .build())
                                .collect(Collectors.toSet()))
                        .build()
                )
                .collect(Collectors.toSet());

        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(0)
                        .errorMessage("success")
                        .data(responses)
                        .build()
        );
    }

    private static Set<TagModel> tagModelSet(Set<TagRequest> tagRequests) {
        return tagRequests.stream()
                .map(tagReq -> TagModel.builder()
                        .tagName(tagReq.getTageName())
                        .build())
                .collect(Collectors.toSet());
    }
}
