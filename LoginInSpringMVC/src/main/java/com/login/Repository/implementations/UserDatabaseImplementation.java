package com.login.Repository.implementations;

import com.login.Connection.implementations.ConnectionProvider;
import com.login.Model.User;
import com.login.Repository.interfaces.IUserDatabaseOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDatabaseImplementation implements IUserDatabaseOperation {
    static Connection con;
    static PreparedStatement ps;

    @Override
    public int insertCustomer(User user) {
        int status = 0;
        try {
            System.out.println("connection done ");
            Connection con = ConnectionProvider.getCon();
            ps = con.prepareStatement("insert into UserDetails(userName,Address,Password,EmailId,RegisterDate) values (?,?,?,?,CURRENT_TIMESTAMP )");

            ps.setString(1, user.getUsername().trim());
            ps.setString(2, user.getAddress());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail().toLowerCase());

            status = ps.executeUpdate();
            System.out.println(status);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public User getUser(String userName, String passwd) {
        User user = new User();

        try {
            con = ConnectionProvider.getCon();

            ps = con.prepareStatement("select  * from UserDetails where Username=? and Password=?");
            ps.setString(1, userName);
            ps.setString(2, passwd);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                user.setUsername(resultSet.getString(2));
                user.setAddress(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setEmail(resultSet.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public User getUser(String emailId) {
        User user = new User();

        try {
            con = ConnectionProvider.getCon();

            ps = con.prepareStatement("select  * from UserDetails where EmailId=?");
            ps.setString(1, emailId);
            System.out.println(user);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                user.setEmail(resultSet.getString(5));
                System.out.println("..................");
                System.out.println(resultSet.getString("userName"));
                System.out.println(resultSet.getString("Address"));

                System.out.println("..................");
                user.setEmail(resultSet.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
}
