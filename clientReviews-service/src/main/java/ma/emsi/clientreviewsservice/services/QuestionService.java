package ma.emsi.clientreviewsservice.services;

import ma.emsi.clientreviewsservice.dtos.QuestionResponseDTO;
import ma.emsi.clientreviewsservice.entities.Question;
import ma.emsi.clientreviewsservice.repositories.ChoiceRepository;
import ma.emsi.clientreviewsservice.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {


    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    public Question findQuestionById(Long questionId){
        return questionRepository.findById(questionId).orElseThrow(()->new RuntimeException("question not find"));
    }
    public List<Question> getAllQuestion(){
//        List<Question> questions=questionRepository.findAll();
//
//        QuestionResponseDTO dto = new QuestionResponseDTO();
//        return questions.stream().map(question -> {
//        dto.setId(question.getId());
//        dto.setText(question.getText());
//        dto.setType(question.getType());
//        dto.setRequired(question.isRequired());
//
//        List<QuestionResponseDTO.ChoiceDTO> choices = question.getChoices().stream().map(choice -> {
//            QuestionResponseDTO.ChoiceDTO choiceDTO = new QuestionResponseDTO.ChoiceDTO();
//            choiceDTO.setId(choice.getId());
//            choiceDTO.setText(choice.getText());
//            return choiceDTO;
//        }).collect(Collectors.toList());
//
//        dto.setChoices(choices);
//        return dto;
//    }).collect(Collectors.toList());
        return questionRepository.findAll();
    }
}
