package com.ann.truckApp.dto.response;

import com.ann.truckApp.domain.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginResponse {
    private Type  type;
    private String  accessToken;
    private String  refreshAccesstoken;
    private String email;

}
