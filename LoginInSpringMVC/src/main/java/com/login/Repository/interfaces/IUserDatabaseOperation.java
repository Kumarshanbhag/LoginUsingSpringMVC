package com.login.Repository.interfaces;
import com.login.Model.User;

public interface IUserDatabaseOperation {
    int insertCustomer(User c);

    User getUser(String userName, String passwd);

    User getUser(String emailId);
}