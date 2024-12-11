package ma.emsi.clientreviewsservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.emsi.clientreviewsservice.enums.QuestionType;

import java.util.List;
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class QuestionResponseDTO {
    private Long id;
    private String text;
    private QuestionType type;
    private boolean required;
    private List<ChoiceDTO> choices;

    // Getters et setters
    @Getter @Setter
    @AllArgsConstructor @NoArgsConstructor
    public static class ChoiceDTO {
        private Long id;
        private String text;

        // Getters et setters
    }
}
