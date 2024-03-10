package com.crud.DAO.Impl;


import com.crud.DAO.Dao;
import com.crud.Model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DaoIml implements Dao {
    private Connection connexion = null;
    private ResultSet resultSet = null;

    public DaoIml() throws SQLException {
        connexion = DaoFactory.getInstance().getConnection();
    }

    @Override
    public void save(Client client) {
        try (
                PreparedStatement statement = connexion.prepareStatement(
                        "INSERT INTO client (email,firstname,lastname,password,phone) VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, client.getEmail());
            statement.setString(2, client.getFirstname());
            statement.setString(3, client.getLastname());
            statement.setString(4, client.getPassword());
            statement.setString(5, client.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> GetAll() {
        try (
                PreparedStatement statement = connexion.prepareStatement("SELECT * FROM client")) {
            ResultSet resultSet = statement.executeQuery();
            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone")
                );
                client.setId(resultSet.getInt("id"));
                clients.add(client);
            }
            return clients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client findById(int id) {
        try (
                PreparedStatement statement = connexion.prepareStatement("SELECT * FROM client WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Client client = new Client(
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone")
                );
                client.setId(resultSet.getInt("id"));
                return client;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Client findByEmail(String email) {
        try (
                PreparedStatement statement = connexion.prepareStatement("SELECT * FROM client WHERE email = ?")) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Client(
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateClient(Client client) {
        try (
                PreparedStatement statement = connexion.prepareStatement(
                        "UPDATE client SET email = ?, firstname = ?, lastname = ?,password = ?,phone = ? WHERE id = ?")) {
            statement.setString(1, client.getEmail());
            statement.setString(2, client.getFirstname());
            statement.setString(3, client.getLastname());
            statement.setString(4, client.getPassword());
            statement.setString(5, client.getPhone());
            statement.setInt(6, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteClient(int id) {
        try (
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM client WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
