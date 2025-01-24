package ma.emsi.clientreviewsservice.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.emsi.clientreviewsservice.entities.Choice;
import ma.emsi.clientreviewsservice.entities.Question;
import ma.emsi.clientreviewsservice.enums.QuestionType;
import ma.emsi.clientreviewsservice.exceptions.InvalidQuestionTypeException;
import ma.emsi.clientreviewsservice.repositories.ChoiceRepository;
import ma.emsi.clientreviewsservice.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChoiceService {

    private final ChoiceRepository choiceRepository;
    private final QuestionRepository questionRepository;

    // Ajouter un nouveau choix
    public List<Choice> addChoices(Long questionId, List<Choice> choices) {

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with ID: " + questionId));
        if (question.getType().equals(QuestionType.MULTIPLECHOICE)){
            // Associez chaque choix à la question
            choices.forEach(choice -> choice.setQuestion(question));

            // Sauvegardez tous les choix
            return choiceRepository.saveAll(choices);
        }
        else {
            throw  new InvalidQuestionTypeException();
        }
    }
    public Choice addOneChoice(Long questionId,Choice choice){
        Question question=questionRepository.findById(questionId).orElseThrow(()->new RuntimeException(""));
        Choice choiceSaved=new Choice(null,choice.getText(),question);
        return choiceRepository.save(choiceSaved);
    }
    // Récupérer tous les choix
    public List<Choice> getAllChoices() {
        return choiceRepository.findAll();
    }

    // Récupérer les choix par question
    public List<Choice> getChoicesByQuestionId(Long questionId) {
        return choiceRepository.findByQuestionId(questionId);
    }

    // Supprimer un choix
    public void deleteChoice(Long choiceId) {
        choiceRepository.deleteById(choiceId);
    }

    // Modifier un choix
    public Choice updateChoice(Long choiceId, String newText) {
        Choice choice = choiceRepository.findById(choiceId)
                .orElseThrow(() -> new EntityNotFoundException("Choice not found with ID: " + choiceId));
        choice.setText(newText);
        return choiceRepository.save(choice);
    }
}

