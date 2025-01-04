package org.example.frontendthymeleaf.model;


import lombok.*;

import java.util.List;
import java.util.Map;

@Builder
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ClientResponse {
    private Long ClientId;
    private Long saleId;
    private List<Map<String,String>> question;
    private String evaluation;
}