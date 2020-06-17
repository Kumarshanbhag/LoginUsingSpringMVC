package com.login.Services;

import com.login.Repository.implementations.UserDatabaseImplementation;
import com.login.Repository.interfaces.IUserDatabaseOperation;
import com.login.Model.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public User logincheck(String username, String password) {
        System.out.println("Login service");
        IUserDatabaseOperation cd = new UserDatabaseImplementation();
        User user = cd.getUser(username, password);
        System.out.println(user.getUsername() + user.getAddress() + user.getEmail() + user.getPassword());
        if(user.getUsername() != null) {
            return user;
        }
        return null;
    }
}
