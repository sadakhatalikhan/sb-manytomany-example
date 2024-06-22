package com.sb.orm.sb.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sb.orm.sb.request.TagRequest;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class PostResponse {

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tags")
    private Set<TagResponse> tags;
}
