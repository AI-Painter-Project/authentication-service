package com.aipainter.authenticationservice.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredUser {
    @Id
    private String email;
    private String name;
    private String pictureUrl;
    private boolean isAdmin;
    private boolean isSuspended;
}
