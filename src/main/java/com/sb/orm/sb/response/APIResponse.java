package com.sb.orm.sb.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
public class APIResponse {
    private int errorCode;
    private String errorMessage;
    private Object data;
}
