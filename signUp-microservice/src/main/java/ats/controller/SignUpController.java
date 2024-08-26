package ats.controller;


import ats.entity.SignUp;
import ats.model.SignUpDTO;
import ats.repository.SignUpRepository;
import ats.utils.EmailValidator;
import ats.utils.IdGenerator;
import ats.utils.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

//import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import static org.hibernate.internal.CoreLogging.logger;

@RestController
@RequestMapping("/api")
public class SignUpController {

    private final SignUpRepository signUpRepository;
    public static final Logger logger = Logger.getLogger(SignUpController.class.getName());

    @Autowired
    public SignUpController(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpDTO signUpFromClient) {
        if (EmailValidator.isValidEmail(signUpFromClient.getEmail()) && PasswordValidator.isValidPassword(signUpFromClient.getPassword())) {
            try {
                SignUp signUpFromDB = signUpRepository.findByEmail(signUpFromClient.getEmail());
                if (signUpFromClient.getEmail().equals(signUpFromDB.getEmail())) {
                    return "User already exists!";
                }
            } catch (NullPointerException exception) {
                System.out.println(exception.getClass());

            }
            SignUp signup = SignUp.getInstance();
            signup.setId(IdGenerator.generateId());
            signup.setEmail(signUpFromClient.getEmail());
            signup.setPassword(signUpFromClient.getPassword());

            signUpRepository.save(signup);
            return "Successfully added to the database";

        } else return "please enter valid email and password";
    }
}
