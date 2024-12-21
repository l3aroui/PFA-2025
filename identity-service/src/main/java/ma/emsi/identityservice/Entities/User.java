package ma.emsi.identityservice.Entities;

import jakarta.persistence.*;
import lombok.*;
import ma.emsi.identityservice.enums.Role;

@Entity @AllArgsConstructor @NoArgsConstructor @Builder @Setter @Getter
@Table(name = "user_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = false)
    private Long keycloakId;
    private String firstname;
    private String lastname;
    @Column(nullable = false,unique = false)
    private String username;
    @Column(nullable = false,unique = false)
    private String email;
    @Column(nullable = false,unique = false)
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "company_id",nullable = false)
    private Company company;
    private Role role;
}
