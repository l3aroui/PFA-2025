package ma.emsi.serviceClient_com.entities;

import jakarta.persistence.*;

import lombok.*;
import ma.emsi.serviceClient_com.enums.Category;
import ma.emsi.serviceClient_com.enums.Type;


import java.util.List;

@Entity

@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long commercialId;
    private Long companyId;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "client")
    private List<Address> address;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<Note> note;
    @Enumerated(EnumType.STRING)
    private Type clientType;
    @Enumerated(EnumType.STRING)
    private Category categoryType;

    public Client(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommercialId() {
        return commercialId;
    }

    public void setCommercialId(Long commercialId) {
        this.commercialId = commercialId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Note> getNote() {
        return note;
    }

    public void setNote(List<Note> note) {
        this.note = note;
    }

    public Type getClientType() {
        return clientType;
    }

    public void setClientType(Type clientType) {
        this.clientType = clientType;
    }

    public Category getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Category categoryType) {
        this.categoryType = categoryType;
    }

    public Client(Long id, Long commercialId, Long companyId, String firstname, String lastname, String email, String phoneNumber, List<Address> address, List<Note> note, Type clientType, Category categoryType) {
        this.id = id;
        this.commercialId = commercialId;
        this.companyId = companyId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.note = note;
        this.clientType = clientType;
        this.categoryType = categoryType;
    }
}
