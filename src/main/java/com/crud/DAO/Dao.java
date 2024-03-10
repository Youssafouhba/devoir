package com.crud.DAO;

import com.crud.Model.Client;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    void save(Client client) throws SQLException;
    List GetAll() throws SQLException;
    void updateClient(Client client) throws SQLException;
    void deleteClient(int id) throws SQLException;
    Client findByEmail(String email) throws SQLException;
    Client findById(int id) throws SQLException;
}
