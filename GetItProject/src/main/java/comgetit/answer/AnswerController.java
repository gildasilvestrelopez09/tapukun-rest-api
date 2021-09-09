package comgetit.answer;

import comgetit.answer.dto.AnswerCreationDTO;
import comgetit.answer.dto.AnswerDTO;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/answer")
    public ResponseEntity<Long> createAnswer(
        @RequestBody @Valid final AnswerCreationDTO answerCreationDTO
    ) {
        Answer answer = answerService.createAnswer(answerCreationDTO);
        return new ResponseEntity(answer.getId(), HttpStatus.CREATED);
    }
    
    @GetMapping("/answers")
    public List<AnswerDTO> getAllAnswers() {
        return answerService.getAllAnswers();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/answer/{id}")
    public Optional<Answer> getAnswerById(@PathVariable Long id) {
        return answerService.findAnswerById(id);
    }
}
