package ma.emsi.clientreviewsservice.controllers;
import ma.emsi.clientreviewsservice.entities.Response;
import ma.emsi.clientreviewsservice.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews/client")
public class ClientController {

    private final ResponseRepository responseRepository;

    @Autowired
    public ClientController(ResponseRepository responseRepository){
        this.responseRepository = responseRepository;
    }

    @PostMapping("/responses")
    public ResponseEntity<List<Response>> saveResponses(@RequestBody List<Response> responses) {
        responseRepository.saveAll(responses);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/form/{saleId}")
    public ResponseEntity<List<Response>> getForm(@PathVariable Long saleId) {
        List<Response> responses = responseRepository.findBySaleId(saleId);
        if (responses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(responses);
    }
}
