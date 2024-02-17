package com.aipainter.authenticationservice.persistence.repositories;

import com.aipainter.authenticationservice.persistence.entities.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<RegisteredUser, String> {}
