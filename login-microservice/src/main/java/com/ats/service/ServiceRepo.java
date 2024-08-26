package com.ats.service;

import com.ats.entity.LogInHistory;
import com.ats.entity.UserDetails;

public interface ServiceRepo {
     Boolean checkForEmailAndPassword(UserDetails userDetailsFromDB, UserDetails userDetailsFromClient);
    int addFailCountByNum(LogInHistory logInHistoryFromDB, int num);
}
