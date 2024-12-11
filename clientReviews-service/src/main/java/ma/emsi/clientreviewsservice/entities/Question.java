package ma.emsi.clientreviewsservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.emsi.clientreviewsservice.enums.QuestionType;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private QuestionType type; // Exemple : "text", "multiple_choice"
    private boolean required;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Choice> choices;
}
