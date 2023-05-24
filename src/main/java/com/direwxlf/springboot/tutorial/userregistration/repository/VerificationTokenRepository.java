package com.direwxlf.springboot.tutorial.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.direwxlf.springboot.tutorial.userregistration.entity.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long>{

    VerificationToken findByToken(String token);
    
}
