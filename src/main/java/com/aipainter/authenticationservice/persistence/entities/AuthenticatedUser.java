package com.aipainter.authenticationservice.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AuthenticatedUser {
    @Id
    private String email;
    private long loginExpiryEpoch;
    private long loginEpoch;
}
