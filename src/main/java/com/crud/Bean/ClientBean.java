package com.crud.Bean;

import com.crud.DAO.Impl.DaoIml;
import com.crud.Model.Client;
import com.crud.Service.ClientService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.crud.Validators.EmailValidator.getLocalizedErrorMessage;

@ManagedBean
@ViewScoped
public class ClientBean implements Serializable{
    private ClientService clientService = new ClientService(new DaoIml());
    private Client client = new Client();
    private  Client newClient = new Client();
    List<Client> clients = new ArrayList<Client>();
    private List<Client> searchResults;

    private boolean editable;
    private boolean editableprevious;
    private boolean editablenext = true;
    private boolean addedit;
    private boolean newbutton;

    private String keyword;


    private int pageSize;
    private int currentPage;
    private int totalPages;


    public ClientBean() throws SQLException {
        clients = clientService.GetAllClient();
        addedit = true;
        pageSize = 5;
        currentPage = 1;
        calculateTotalPages();
    }

    public void updateClient(Client clien){
        clien.setId(client.getId());
        clientService.updateClient(clien);
        clients = clientService.GetAllClient();
        editable=!editable;
    }

    public void createClient(Client c)  {
        boolean success = clientService.createClient(c);
        String errorMessage1 = getLocalizedErrorMessage("createsucMessage");
        String errorMessage = getLocalizedErrorMessage("createerrorMessage");
        if (success) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("message", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", errorMessage1));
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("message", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", errorMessage));
        }
    }



    public String deleteClient(int id){
        clientService.deleteClient(id);
        return "ListClients?faces-redirect=true";
    }

    public List<Client> getClients(){
        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, clients.size());
        return clients.subList(startIndex, endIndex);
    }

    public int getPageSize() {
        return pageSize;
    }
    public void previousPage() {
        if (currentPage > 1) {
            editablenext = true;
            currentPage--;
        }
        if (currentPage==1){
            editablenext = true;
            editableprevious = false;
        }
    }



    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }



    public void search() {
        searchResults = new ArrayList<>();
        for (Client client : clients) {
            if (client.getFirstname().contains(keyword) || client.getLastname().contains(keyword)) {
                searchResults.add(client);
            }
        }
        this.clients = searchResults;
        resetClientEditableStates();
    }

    public void resetClientEditableStates() {
        for (Client client : clients) {
            client.setEditable(false);
        }
    }



    public void nextPage() {
        if (currentPage < totalPages) {
            editableprevious=true;
            editablenext = true;
            currentPage++;
        }
        if(currentPage==totalPages){
            editablenext = false;
        }
    }

    public void toggleInputs(Client clien) {
        client = clien;
        editable=!editable;
        if(!addedit){
            addedit=true;
        }
        clien.toggleInputs();
    }
    public void toggleadd(Client cc){
        editable=false;
        cc.setEditable(false);
        Client c = new Client();
        for(Client clien : clients){
            c.setId(clien.getId()+1);
        }
        newClient.setId(c.getId());
        c.setNewbutton(true);
        clients.add(c);
        calculateTotalPages();
        currentPage=totalPages;
        nextPage();
        editableprevious=true;
        addedit = !addedit;
    }
    public String annuler(){
        return "ListClients?faces-redirect=true";
    }

    public boolean isEditableprevious() {
        return editableprevious;
    }

    public void setEditableprevious(boolean editableprevious) {
        this.editableprevious = editableprevious;
    }

    public boolean isEditablenext() {
        return editablenext;
    }

    public void setEditablenext(boolean editablenext) {
        this.editablenext = editablenext;
    }


    public boolean isAddedit() {
        return addedit;
    }

    public void setAddedit(boolean addedit) {
        this.addedit = addedit;
    }

    public Client getNewClient() {
        return newClient;
    }

    public void setNewClient(Client newClient) {
        this.newClient = newClient;
    }

    public boolean isNewbutton() {
        return newbutton;
    }

    public void setNewbutton(boolean newbutton) {
        this.newbutton = newbutton;
    }
    private void calculateTotalPages() {
        totalPages = (int) Math.ceil((double) clients.size() / pageSize);
    }
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) clients.size() / pageSize);
    }

    public Client getClient(){
        return client;
    }


    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}