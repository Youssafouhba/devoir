package com.crud.Model;

public class Client {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private  boolean editable;
    private boolean newbutton;

    public Client(String firstname,String lastname, String email, String password,String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    public Client(String email,String password){
        this.email = email;
        this.password = password;
    }

    public Client() {
        this.editable = false; // Défaut à false lors de la création d'une nouvelle instance
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstname() {
        return firstname;
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }




    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public void toggleInputs() {
        this.editable = !this.editable;
    }

    public boolean isNewbutton() {
        return newbutton;
    }

    public void setNewbutton(boolean newbutton) {
        this.newbutton = newbutton;
    }
}