package ma.emsi.clientreviewsservice.controllers;
import ma.emsi.clientreviewsservice.entities.Choice;
import ma.emsi.clientreviewsservice.entities.Question;
import ma.emsi.clientreviewsservice.entities.Response;
import ma.emsi.clientreviewsservice.repositories.ChoiceRepository;
import ma.emsi.clientreviewsservice.repositories.QuestionRepository;
import ma.emsi.clientreviewsservice.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reviews/client")
public class ResponseController {
    private final ResponseRepository responseRepository;

    private final QuestionRepository questionRepository;
    private final ChoiceRepository choiceRepository;
    @Autowired
    public ResponseController(ResponseRepository responseRepository, QuestionRepository questionRepository, ChoiceRepository choiceRepository) {
        this.responseRepository = responseRepository;
        this.questionRepository = questionRepository;
        this.choiceRepository = choiceRepository;
    }

//        @PostMapping("/saveResponse/{clientId}/{saleId}")
//    public ResponseEntity<List<Response>> saveResponses(@RequestBody List<Map<String,String>> responses,
//                                                        @PathVariable Long clientId,
//                                                        @PathVariable Long saleId) {
//        for(int i=0;i<responses.size();i++){
//            Response response=new Response(null,saleId,clientId,responses.get(i).get("question"),responses.get(i).get("response"),null);
//            responseRepository.save(response);
//        }
//        return ResponseEntity.ok().body(null);
//    }
//@PostMapping("/saveResponse/{clientId}/{saleId}")
//public ResponseEntity<?> saveResponses(
//        @RequestBody List<Map<String, String>> responses,
//        @PathVariable Long clientId,
//        @PathVariable Long saleId) {
//
//    return
//}


    @GetMapping("/response/{id}")
    public ResponseEntity<List<Map<String,String>>> getResponse(@PathVariable("id") Long clientId){
        List<Response> responses=responseRepository.findAllByClientId(clientId);
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
