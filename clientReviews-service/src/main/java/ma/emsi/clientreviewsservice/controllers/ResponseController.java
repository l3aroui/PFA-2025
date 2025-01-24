package ma.emsi.clientreviewsservice.controllers;
import ma.emsi.clientreviewsservice.entities.Response;
import ma.emsi.clientreviewsservice.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reviews/client")
public class ResponseController {
    private final ResponseRepository responseRepository;
    @Autowired
    public ResponseController(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @PostMapping("/saveResponse/{saleId}")
    public ResponseEntity<?> saveResponses(
            @RequestBody List<Response> responses,
            @PathVariable Long saleId) {
        List<Response> savedResponses=new ArrayList<>();
        for (Response respons : responses) {
            Response response = new Response();
            response.setChoice(respons.getChoice());
            response.setSaleId(saleId);
            response.setQuestion(respons.getQuestion());
            response.setCustomResponse(respons.getCustomResponse());
            savedResponses.add(response);
        }
        return ResponseEntity.ok().body(responseRepository.saveAll(savedResponses));
    }

    @GetMapping("/response/{id}")
    public ResponseEntity<List<Map<String,String>>> getResponse(@PathVariable("id") Long saleId){
        List<Response> responses=responseRepository.findAllBySaleId(saleId);
        List<Map<String,String>> clientResponse=responses.stream().map(response -> Map.of(
                "question",response.getQuestion().getText(),
                "response",response.getChoice().getText())).collect(Collectors.toList());
        return ResponseEntity.ok(clientResponse);
    }

//    @GetMapping("/form")
//    public ResponseEntity<List<Question>> getForm() {
//        List<Question> questions = questionRepository.findAll();
//        return ResponseEntity.ok(questions);
//    }

}
