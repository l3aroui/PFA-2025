package org.example.frontendthymeleaf.model;


import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter
public class Product {
    private String name;
    private String price;
    private double quantity;
    private String description;
    private Long id;

}
