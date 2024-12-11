package ma.emsi.serviceClient_com.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder

@Getter @Setter

public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne
    private Client client;

    public Note(Long id, String text, Client client) {
        this.id = id;
        this.text = text;
        this.client = client;
    }
    public Note(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
