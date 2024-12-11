package ma.emsi.clientreviewsservice.entities;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor @NoArgsConstructor
@Builder
@Getter @Setter
@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long saleId;
    private Long clientId;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "choice_id", nullable = true)
    private Choice choice;
    @Column(nullable = true)
    private String responseText;
}
