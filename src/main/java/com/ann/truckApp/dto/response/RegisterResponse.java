package com.ann.truckApp.dto.response;

import com.ann.truckApp.domain.enums.Type;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterResponse {
    private String email;
    private String status;
    private String message;
    private Type type;



}