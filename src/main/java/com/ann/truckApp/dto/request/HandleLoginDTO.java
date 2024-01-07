package com.ann.truckApp.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class HandleLoginDTO {
    private String email;
    private String password;
}
