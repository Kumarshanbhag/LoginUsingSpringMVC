package com.login.Services;

import com.login.Model.User;
import com.login.Repository.implementations.UserDatabaseImplementation;
import com.login.Repository.interfaces.IUserDatabaseOperation;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    //Min 3 character required and start with capital
    static final String VALID_NAME = "^[A-Z][a-z]{2,}$";
    //abc@gmail.com
    static final String VALID_EMAIL = "^[a-zA-Z0-9]{3,}[@][a-zA-Z0-9]+[.][a-zA-Z]{2,3}$";
    //Min 5 character and start With Capital
    static final String VALID_ADDRESS = "^[A-Z][a-z]{5,}$";
    //Minimum 8 Character And 5 Character And 3 Number Compulsory
    static final String VALID_PASSWORD = "^[A-Za-z]{5,}[0-9]{3,}$";

    String error = null;

    public String check(User user) {
        error = null;
        patterncheck(user);
        if (error == null) {
            IUserDatabaseOperation ud = new UserDatabaseImplementation();
            User user1 = ud.getUser(user.getEmail());
            System.out.println(user1.getEmail());
            if (user1.getEmail() == null) {
                int result = ud.insertCustomer(user);
                System.out.println(result);
                if (result != 0) {
                    return error;
                }
            }
            error = "Email Already Present In Database";
        }
        return error;
    }

    private void patterncheck(User user) {
        if (!user.getUsername().matches(VALID_NAME) && error == null) {
            error = "Username should have min 3 character required and start with capital";
        }
        if (!user.getAddress().matches(VALID_ADDRESS) && error == null) {
            error = "Address should have min 5 character and start With Capital";
        }
        if (!user.getPassword().matches(VALID_PASSWORD) && error == null) {
            error = "Password should have min 8 Character And min first 5 Letters And last 3 number";
        }
        if (!user.getEmail().matches(VALID_EMAIL) && error == null) {
            error = "Email Should have min 3 character required and start with capital";
        }
    }
}
