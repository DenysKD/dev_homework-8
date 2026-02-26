package org.example.task2.Client;

import org.example.DBConnection.DatabaseConnectoin;
import org.example.task2.DAO.ClientDaoSecvice;

import java.security.InvalidParameterException;
import java.sql.*;
import java.util.List;

public class ClientService {
    private static ClientDaoSecvice daoSecvice = new ClientDaoSecvice();

    public static void main(String[] args) {
        try {
            System.out.println(create("John Snow"));
            List<Client> clientList = listAll();
            System.out.println("=====================");
            listAll().forEach(client -> System.out.println(client.toString()));
            System.out.println("=====================");
            System.out.println(getById(3));
            setName(5, "King Lich");
            System.out.println("=====================");
            listAll().forEach(client -> System.out.println(client.toString()));
            System.out.println("=====================");
            deleteById(4);
            System.out.println("=====================");
            listAll().forEach(client -> System.out.println(client.toString()));
            System.out.println("=====================");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static long create(String name){
        if(!(name.length() >= 2 && name.length() <= 1000)){ throw  new InvalidParameterException("Name too short of too long!");}
        return daoSecvice.create(name);
    }

    public static String getById(long id){
        if(id <= 0) throw new IllegalArgumentException("Incorrect id!");
        return daoSecvice.getById(id);
    }

    public static void setName(long id, String name) throws SQLException {
        if(id <= 0) throw new IllegalArgumentException("Incorrect id!");
        if(name == null || name.isBlank()) throw new IllegalArgumentException("Incorrect id!");
        daoSecvice.setName(id, name);
    }

    public static void deleteById(long id) throws SQLException {
        if(id <= 0) throw new IllegalArgumentException("Incorrect id!");
        daoSecvice.deleteById(id);
    }

    public static List<Client> listAll() throws SQLException {
        if(daoSecvice.listAll().size() == 0) throw new RuntimeException("Table is empty");
        else return daoSecvice.listAll();
    }




}
