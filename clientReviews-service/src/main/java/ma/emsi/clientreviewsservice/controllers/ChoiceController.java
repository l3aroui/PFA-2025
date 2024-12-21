package ma.emsi.clientreviewsservice.controllers;


import lombok.RequiredArgsConstructor;
import ma.emsi.clientreviewsservice.entities.Choice;
import ma.emsi.clientreviewsservice.exceptions.InvalidQuestionTypeException;
import ma.emsi.clientreviewsservice.services.ChoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/reviews/choices")
@RequiredArgsConstructor
public class ChoiceController {
    private final ChoiceService choiceService;

    // Endpoint pour ajouter un choix
    @ExceptionHandler(InvalidQuestionTypeException.class)
    @PostMapping("/{questionId}")
    public ResponseEntity<List<Choice>> addChoices(
            @PathVariable Long questionId,
            @RequestBody List<Choice> choices) {
        List<Choice> savedChoices = choiceService.addChoices(questionId, choices);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedChoices);
    }

    // Endpoint pour récupérer tous les choix
    @GetMapping
    public ResponseEntity<List<Choice>> getAllChoices() {
        List<Choice> choices = choiceService.getAllChoices();
        return ResponseEntity.ok(choices);
    }

    // Endpoint pour récupérer les choix par question
    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Choice>> getChoicesByQuestionId(@PathVariable Long questionId) {
        List<Choice> choices = choiceService.getChoicesByQuestionId(questionId);
        return ResponseEntity.ok(choices);
    }

    // Endpoint pour supprimer un choix
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChoice(@PathVariable Long id) {
        choiceService.deleteChoice(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint pour mettre à jour un choix
    @PutMapping("/{id}")
    public ResponseEntity<Choice> updateChoice(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {
        String newText = request.get("text");
        Choice updatedChoice = choiceService.updateChoice(id, newText);
        return ResponseEntity.ok(updatedChoice);
    }
}
