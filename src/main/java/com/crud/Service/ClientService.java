package com.crud.Service;

import com.crud.DAO.Impl.DaoIml;
import com.crud.Model.Client;

import java.util.List;

public class ClientService {

    public final DaoIml clientDaoIml;

    public ClientService(DaoIml clientDaoIml) {
        this.clientDaoIml = clientDaoIml;
    }

    public List<Client> GetAllClient(){
        return clientDaoIml.GetAll();
    }

    public boolean createClient(Client client){
        if(clientDaoIml.findByEmail(client.getEmail())==null){
            clientDaoIml.save(client);
            return true;
        }else {
            return false;
        }
    }

    public void updateClient(Client client){
        clientDaoIml.updateClient(client);
    }

    public void deleteClient(int id){
        clientDaoIml.deleteClient(id);
    }

    public Client findbyid(int id){
        return clientDaoIml.findById(id);
    }

}
