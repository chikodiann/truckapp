package com.ann.truckApp.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class HandleRegisterDTO {
    private String username;
    private String email;
    private String password;

}
