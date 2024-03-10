package com.crud.DAO.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;
public class DaoFactory {
    private final String url;
    private final String username;
    private final String password;
    public DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    public static DaoFactory getInstance() {
        try {
            forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

        }
        return new DaoFactory("jdbc:mysql://mysql-2c3b7474-youssefouhba-1406.a.aivencloud.com:23229/hi", "avnadmin", "AVNS_hdj58afUSowWP3eu2GF");
    }
    public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://mysql-2c3b7474-youssefouhba-1406.a.aivencloud.com:23229/hi?user=avnadmin&password=AVNS_hdj58afUSowWP3eu2GF");
        return con;
    }
}