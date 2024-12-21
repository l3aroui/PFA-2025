package org.example.frontendthymeleaf.model;


import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
public class Choice {
    private Long id;
    private String text;
}
