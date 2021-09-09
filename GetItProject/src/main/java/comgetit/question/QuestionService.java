package comgetit.question;

import comgetit.question.dto.QuestionCreationDTO;
import comgetit.question.dto.QuestionDTO;
import comgetit.questionary.Questionary;
import comgetit.questionary.QuestionaryRepository;
import comgetit.questionary.exception.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionaryRepository questionaryRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository,
    		QuestionaryRepository questionaryRepository) {
        this.questionRepository = questionRepository;
        this.questionaryRepository = questionaryRepository;
    }

    public Question createQuestion(final QuestionCreationDTO questionCreationDTO) {
    	Questionary questionary = questionaryRepository.findById(questionCreationDTO.getParentId())
                .orElseThrow(QuestionaryNotFoundException::new);
        Question question = new Question(UUID.randomUUID().getMostSignificantBits()
            , questionCreationDTO.getQuestion(), questionCreationDTO.getOptions()
            , questionCreationDTO.getRightAnswer(), questionCreationDTO.getDeadTime(), 
            questionCreationDTO.getScore(), questionary);
        return questionRepository.save(question);
    }

    public List<QuestionDTO> getAllQuestions() {
        return questionRepository.findAll().stream()
            .map(QuestionDTO::new)
            .collect(Collectors.toList());
    }
    
    public Optional<Question> findQuestionById(long id) {
        return questionRepository.findById(id);
    }
}
