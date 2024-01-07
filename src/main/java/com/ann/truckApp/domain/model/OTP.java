package com.ann.truckApp.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OTP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long otp_id;
    private String otp;
    private LocalDateTime expiration;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id" ,nullable = false)
    private Users users;

}
