package org.example.frontendthymeleaf.model;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Question {
    private Long id;
    private String text;
    private String type;
    private Boolean required;
    List<Choice> choices;
}
