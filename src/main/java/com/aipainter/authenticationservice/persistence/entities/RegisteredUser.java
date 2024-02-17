package com.aipainter.authenticationservice.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "registered_user")
public class RegisteredUser {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "picture_url")
    private String pictureUrl;
    @Column(name = "admin")
    private boolean isAdmin;
    @Column(name = "suspended")
    private boolean isSuspended;
}
