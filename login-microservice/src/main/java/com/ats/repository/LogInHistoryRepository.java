package com.ats.repository;

import com.ats.entity.LogInHistory;
import com.ats.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogInHistoryRepository extends JpaRepository<LogInHistory,String> {

//    LogInHistory findByEmail(String email);

}
