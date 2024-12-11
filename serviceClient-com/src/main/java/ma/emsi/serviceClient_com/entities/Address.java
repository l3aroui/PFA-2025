package ma.emsi.serviceClient_com.entities;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Builder

@Getter @Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contry;
    private String city;
    private String district;

    @ManyToOne(targetEntity = Client.class,fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Client client;

    public Address(Long id, String contry, String city, String district, Client client) {
        this.id = id;
        this.contry = contry;
        this.city = city;
        this.district = district;
        this.client = client;
    }
    public Address(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
