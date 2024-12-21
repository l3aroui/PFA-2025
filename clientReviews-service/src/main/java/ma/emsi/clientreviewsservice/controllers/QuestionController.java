package ma.emsi.clientreviewsservice.controllers;

import ma.emsi.clientreviewsservice.dtos.QuestionResponseDTO;
import ma.emsi.clientreviewsservice.entities.Question;
import ma.emsi.clientreviewsservice.repositories.QuestionRepository;
import ma.emsi.clientreviewsservice.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/v1/reviews/admin/question")
public class QuestionController {

    private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    @Autowired
    public QuestionController(QuestionRepository questionRepository, QuestionService questionService) {
        this.questionRepository = questionRepository;
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestion());
    }

    @PostMapping("/add")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionRepository.save(question));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        Question question = questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
        question.setText(updatedQuestion.getText());
        question.setType(updatedQuestion.getType());
        question.setRequired(updatedQuestion.isRequired());
        return ResponseEntity.ok(questionRepository.save(question));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        questionRepository.deleteById(id);
        return ResponseEntity.ok("Question supprimée avec succès");
    }

    @GetMapping("/urlGenerate/{saleId}")
    public ResponseEntity<String> urlGenerate(@PathVariable Long saleId){
        return ResponseEntity.ok("http://localhost:8010/api/v1/reviews/client/form/"+saleId);
    }
}
