package org.example.frontendthymeleaf.model;


import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter
public class Client {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String categoryType;
    private String clientType;
}
