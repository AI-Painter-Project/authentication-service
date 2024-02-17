package com.aipainter.authenticationservice.persistence.repositories;

import com.aipainter.authenticationservice.persistence.entities.AuthenticatedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticatedUserRepository extends JpaRepository<AuthenticatedUser, String> {}
