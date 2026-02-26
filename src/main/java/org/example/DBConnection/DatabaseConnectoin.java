package org.example.DBConnection;

import org.flywaydb.core.Flyway;

import java.lang.classfile.instruction.StackInstruction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectoin {
    private static DatabaseConnectoin instance = new DatabaseConnectoin();

    private static Connection connection;

    private DatabaseConnectoin(){
        String url = PropertyReader.getConnectionURL();
        String userName = PropertyReader.getUserName();
        String password = PropertyReader.getPassword();

        try{
            connection = DriverManager.getConnection(url, userName, password);
            flywayMigration(url, userName, password);
        } catch (SQLException e) {
            System.out.println("SQL exception");
            throw new RuntimeException("Can not create connection", e);
        }
    }

    public static DatabaseConnectoin getInstance() { return instance; }
    public static Connection getConnection(){
        return connection;
    }

    public void flywayMigration(String url, String userName, String password){
        Flyway flyway = Flyway.configure().dataSource(url, userName, password).load();
        flyway.migrate();
    }


}
