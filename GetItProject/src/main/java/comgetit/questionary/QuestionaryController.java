package comgetit.questionary;

import comgetit.questionary.dto.QuestionaryCreationDTO;
import comgetit.questionary.dto.QuestionaryDTO;
import comgetit.user.User;

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
public class QuestionaryController {

    private QuestionaryService questionaryService;

    @Autowired
    public QuestionaryController(QuestionaryService questionaryService) {
        this.questionaryService = questionaryService;
    }

    @PostMapping("/questionary")
    public ResponseEntity<Long> createQuestionary(
        @RequestBody @Valid final QuestionaryCreationDTO questionaryCreationDTO
    ) {
        Questionary questionary = questionaryService.createQuestionary(questionaryCreationDTO);
        return new ResponseEntity(questionary.getId(), HttpStatus.CREATED);
    }
    
    @GetMapping("/questionaries")
    public List<QuestionaryDTO> getAllQuestionaries() {
        return questionaryService.getAllQuestionaries();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/questionary/{id}")
    public Optional<Questionary> getQuestionaryById(@PathVariable Long id) {
        return questionaryService.findQuestionaryById(id);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/questionary-code/{code}")
    public Optional<Questionary> getQuestionaryByAccessCode(@PathVariable String code) {
        return questionaryService.findQuestionaryByAccessCode(code);
    }
}
