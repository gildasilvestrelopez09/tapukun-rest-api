package comgetit.question;

import comgetit.question.dto.QuestionCreationDTO;
import comgetit.question.dto.QuestionDTO;
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
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/question")
    public ResponseEntity<Long> createQuestion(
        @RequestBody @Valid final QuestionCreationDTO questionCreationDTO
    ) {
        Question question = questionService.createQuestion(questionCreationDTO);
        return new ResponseEntity(question.getId(), HttpStatus.CREATED);
    }
    
    @GetMapping("/questions")
    public List<QuestionDTO> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/question/{id}")
    public Optional<Question> getQuestionById(@PathVariable Long id) {
        return questionService.findQuestionById(id);
    }
}
