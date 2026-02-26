package org.example.task2.DAO;

import org.example.DBConnection.DatabaseConnectoin;
import org.example.task2.Client.Client;

import java.security.InvalidParameterException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoSecvice {
    private static Connection connection = DatabaseConnectoin.getConnection();

    public long create(String name){
        final String INSERT_INTO_CLIENT = "INSERT INTO client(name) VALUES (?)";
        try(PreparedStatement clientInitPS = connection.prepareStatement(INSERT_INTO_CLIENT, Statement.RETURN_GENERATED_KEYS)) {
            clientInitPS.setString(1, name);
            clientInitPS.executeUpdate();

            try(ResultSet rs = clientInitPS.getGeneratedKeys()) {
                if(rs.next()) return rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException();
    }

    public String getById(long id){
        final String SELECT_BY_ID = "SELECT name FROM client WHERE ID = ?";
        try(PreparedStatement selectByID = connection.prepareStatement(SELECT_BY_ID)){
            selectByID.setLong(1, id);

            try(ResultSet rs = selectByID.executeQuery()) {
                if(rs.next()) return rs.getString(1);

                else throw new InvalidParameterException("The client with this ID does not exist!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setName(long id, String name) throws SQLException {
        final String CHANGE_NAME_BY_ID = "UPDATE client SET name = ? WHERE ID = ? ";

        try(PreparedStatement changeName = connection.prepareStatement(CHANGE_NAME_BY_ID)) {
            changeName.setString(1, name);
            changeName.setLong(2, id);

            if(changeName.executeUpdate() == 0) throw new InvalidParameterException("The client with this ID does not exist!");
        }
    }

    public void deleteById(long id) throws SQLException {
        final String DELETE_BY_ID = "DELETE FROM client WHERE id = ?";
        try(PreparedStatement deleteClientById = connection.prepareStatement(DELETE_BY_ID)) {
            deleteClientById.setLong(1, id);

            if(deleteClientById.executeUpdate() == 0) throw new SQLException("The client with this ID does not exist!");
        }
    }

    public List<Client> listAll() throws SQLException {
        final String SELECT_ALL_CLIENTS = "SELECT * FROM CLIENT";
        List<Client> clients = new ArrayList<>();
        try(PreparedStatement selectAllClients = connection.prepareStatement(SELECT_ALL_CLIENTS)) {
            try(ResultSet rs = selectAllClients.executeQuery()) {
                while (rs.next()){
                    clients.add(new Client(rs.getInt(1), rs.getString(2)));
                }
            }
        }
        return clients;
    }
}
