package org.example.frontendthymeleaf.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String positionApplied;
    private String status; // Par exemple : Applied, Interviewed, Hired, Rejected
}

