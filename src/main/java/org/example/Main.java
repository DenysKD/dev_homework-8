package org.example;

import org.example.DBConnection.DatabaseConnectoin;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectoin db = DatabaseConnectoin.getInstance();
        Connection connection = DatabaseConnectoin.getConnection();
    }
}

