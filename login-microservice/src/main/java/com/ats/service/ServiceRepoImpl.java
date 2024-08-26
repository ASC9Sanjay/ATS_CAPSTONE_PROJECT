package com.ats.service;

import com.ats.entity.LogInHistory;
import com.ats.entity.UserDetails;
import com.ats.repository.LogInHistoryRepository;
import com.ats.repository.UserRepository;
import com.ats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ServiceRepoImpl implements ServiceRepo{

    private final LogInHistoryRepository logInHistoryRepository;
    private final UserRepository userRepository;

    @Autowired
    public ServiceRepoImpl(LogInHistoryRepository logInHistoryRepository, UserRepository userRepository) {
        this.logInHistoryRepository = logInHistoryRepository;
        this.userRepository = userRepository;
    }

    public boolean isValidEmail(String email){
        System.out.println("email validator"+ Utils.isValidEmail(email));
        return Utils.isValidEmail(email);
    }

    public boolean isValidPassword(String password){
        System.out.println("password validator"+ Utils.isValidPassword(password));
        return Utils.isValidPassword(password);
    }

    @Override
    public Boolean checkForEmailAndPassword(UserDetails userDetailsFromDB, UserDetails userDetailsFromClient) {
        if(userDetailsFromDB.getEmail().equals(userDetailsFromClient.getEmail()) && userDetailsFromDB.getPassword().equals(userDetailsFromClient.getPassword())){
            return true;
        }else return false;
    }

    @Override
    public int addFailCountByNum(LogInHistory logInHistoryFromDB, int num) {
        return logInHistoryFromDB.getFailedCount() + num;
    }

}
