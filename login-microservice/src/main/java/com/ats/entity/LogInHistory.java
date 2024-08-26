package com.ats.entity;

//import jakarta.persistence.*;

import javax.persistence.*;
//import javax.persistence.Id;
//import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "login_history")
public class LogInHistory {

    LogInHistory(){

    }

    public LogInHistory(String id , Timestamp lastAttempt , int failedCount , Timestamp lockedUntill){
        this.logInId = id;
        this.lastAttempt = lastAttempt;
        this.failedCount = failedCount;
        this.lockedUntill = lockedUntill;
    }

    @Id
    private String logInId;
    @Column(name = "last_attempt", nullable = false)
    private Timestamp lastAttempt;
    @Column(name = "failed_count", nullable = false)
    private int failedCount;
    @Column(name="locked_untill",nullable = true)
    private Timestamp lockedUntill;

    public String getLogInId() {
        return logInId;
    }

    public void setLogInId(String logInId) {
        this.logInId = logInId;
    }

    public void setFailedCount(int failedCount) {
        this.failedCount = failedCount;
    }
    public int getFailedCount() {
        return failedCount;
    }

    public void setLastAttempt(Timestamp lastAttempt) {
        this.lastAttempt = lastAttempt;
    }

    public Timestamp getLastAttempt() {
        return lastAttempt;
    }

    public void setLockedUntill(Timestamp lockedUntill) {
        this.lockedUntill = lockedUntill;
    }

    public Timestamp getLockedUntill() {
        return lockedUntill;
    }
}
