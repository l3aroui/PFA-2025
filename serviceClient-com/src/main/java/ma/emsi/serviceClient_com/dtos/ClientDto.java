package ma.emsi.serviceClient_com.dtos;


import lombok.*;

import ma.emsi.serviceClient_com.enums.Category;
import ma.emsi.serviceClient_com.enums.Type;



@Builder
public class ClientDto {
    private Long commercialId;
    private Long companyId;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private Category categoryType;
    private Type clientType;

    public ClientDto(Long commercialId, Long companyId, String firstname, String lastname, String email, String phoneNumber, Category categoryType, Type clientType) {
        this.commercialId = commercialId;
        this.companyId = companyId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.categoryType = categoryType;
        this.clientType = clientType;
    }

    public ClientDto(){}

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

    public Category getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Category categoryType) {
        this.categoryType = categoryType;
    }

    public Type getClientType() {
        return clientType;
    }

    public void setClientType(Type clientType) {
        this.clientType = clientType;
    }
}
