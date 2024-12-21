package ma.emsi.identityservice.Entities;


import jakarta.persistence.*;
import lombok.*;
import ma.emsi.identityservice.enums.CompanyType;

import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private CompanyType companyType;
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<User> users;
}
