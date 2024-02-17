package com.aipainter.authenticationservice.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "authenticated_user")
public class AuthenticatedUser {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "login_expiry_epoch")
    private Instant loginExpiryEpoch;
    @Column(name = "login_epoch")
    private Instant loginEpoch;
}
