package org.example.frontendthymeleaf.model;


import lombok.*;

import java.util.List;
import java.util.Map;

@Builder
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ClientResponse {
    private Long questionId;
    private Long  choiceId;
    private String customResponse;
}