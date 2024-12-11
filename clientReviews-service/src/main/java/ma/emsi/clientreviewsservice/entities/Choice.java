package ma.emsi.clientreviewsservice.entities;

import jakarta.persistence.*;
import lombok.*;


@Setter @Getter
@Builder @AllArgsConstructor @NoArgsConstructor
@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
