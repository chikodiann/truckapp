package com.ann.truckApp.domain.model;

import com.ann.truckApp.domain.enums.Type;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status;

    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Type type;
}
