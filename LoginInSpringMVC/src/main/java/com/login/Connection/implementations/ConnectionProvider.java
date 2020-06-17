package com.login.Connection.implementations;

import com.login.Connection.interfaces.Provider;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Provider {
    static Connection con = null;

    public static Connection getCon() {
        System.out.println("Connection Class");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(connURL, username, psswd);
            System.out.println(con);

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}

