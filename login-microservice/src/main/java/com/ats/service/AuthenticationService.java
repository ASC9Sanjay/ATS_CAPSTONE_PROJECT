package com.ats.service;

import com.ats.entity.LogInHistory;
import com.ats.entity.UserDetails;
import com.ats.exception.AccountLockedException;
import com.ats.exception.InvalidCredentialsException;
import com.ats.repository.LogInHistoryRepository;
import com.ats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
    public class AuthenticationService {

        private static final int MAX_FAILED_ATTEMPTS = 3;
        private static final long LOCK_TIME_DURATION = 60; // in seconds

        private final UserRepository userRepository;
        private final LogInHistoryRepository logInHistoryRepository;
//        private final PasswordEncoder passwordEncoder;

        @Autowired
        public AuthenticationService(UserRepository userRepository,
                                     LogInHistoryRepository logInHistoryRepository) {
            this.userRepository = userRepository;
            this.logInHistoryRepository = logInHistoryRepository;
        }

        public UserDetails authenticate(UserDetails userDetailsFromClient) throws InvalidCredentialsException, AccountLockedException {
            UserDetails userDetailsFromDB = userRepository.findByEmail(userDetailsFromClient.getEmail())
                    .orElseThrow(() -> new InvalidCredentialsException("Invalid email or password"));

            LogInHistory logInHistory = logInHistoryRepository.findById(userDetailsFromDB.getId())
                    .orElse(new LogInHistory(userDetailsFromDB.getId(),Timestamp.from(Instant.now()),1,null));

            if (isAccountLocked(logInHistory)) {
                throw new AccountLockedException("Account is locked. Please try again later.");
            }

            if (isValidCredentials(userDetailsFromClient, userDetailsFromDB)) {
                resetFailedAttempts(logInHistory);
                return userDetailsFromDB;
            } else {
                incrementFailedAttempts(logInHistory);
                throw new InvalidCredentialsException("Invalid email or password");
            }
        }

        private boolean isAccountLocked(LogInHistory logInHistory) {
            if (logInHistory.getLockedUntill() == null) {
                return false;
            }
            return Instant.now().isBefore(logInHistory.getLockedUntill().toInstant());
        }

        private boolean isValidCredentials(UserDetails userDetailsFromClient, UserDetails userDetailsFromDB) {
            return userDetailsFromClient.getPassword().equals(userDetailsFromDB.getPassword());
        }

        private void resetFailedAttempts(LogInHistory logInHistory) {
            logInHistory.setFailedCount(0);
            logInHistory.setLastAttempt(Timestamp.from(Instant.now()));
            logInHistory.setLockedUntill(null);
            logInHistoryRepository.save(logInHistory);
        }

        private void incrementFailedAttempts(LogInHistory logInHistory) {
            logInHistory.setFailedCount(logInHistory.getFailedCount() + 1);
            logInHistory.setLastAttempt(Timestamp.from(Instant.now()));

            if (logInHistory.getFailedCount() >= MAX_FAILED_ATTEMPTS) {
                Instant lockTime = Instant.now().plus(LOCK_TIME_DURATION, ChronoUnit.SECONDS);
                logInHistory.setLockedUntill(Timestamp.from(lockTime));
                logInHistory.setFailedCount(0);
            }

            logInHistoryRepository.save(logInHistory);
        }
    }

