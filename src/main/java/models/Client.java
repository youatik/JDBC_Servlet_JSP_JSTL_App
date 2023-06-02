/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author youatik
 */
public class Client {
    private int clientId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    public Client() {
        // Default constructor
    }

    public Client(int clientId, String firstName, String lastName, String email, String phone, String address) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Client{")
      .append("clientId=").append(clientId)
      .append(", firstName='").append(firstName).append('\'')
      .append(", lastName='").append(lastName).append('\'')
      .append(", email='").append(email).append('\'')
      .append(", phone='").append(phone).append('\'')
      .append(", address='").append(address).append('\'')
      .append('}');
    return sb.toString();
}
}

