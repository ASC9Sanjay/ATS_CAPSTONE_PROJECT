package com.ats.repository;

import com.ats.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,Long> {
    Optional<UserDetails> findByEmail(String email);
}
