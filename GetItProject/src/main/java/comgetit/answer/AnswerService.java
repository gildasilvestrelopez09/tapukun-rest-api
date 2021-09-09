package comgetit.answer;

import comgetit.answer.dto.AnswerCreationDTO;
import comgetit.answer.dto.AnswerDTO;
import comgetit.question.Question;
import comgetit.question.QuestionRepository;
import comgetit.questionary.exception.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository,
    		QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public Answer createAnswer(final AnswerCreationDTO answerCreationDTO) {
    	Question question = questionRepository.findById(answerCreationDTO.getQuestionId())
                .orElseThrow(QuestionaryNotFoundException::new);
        Answer answer = new Answer(UUID.randomUUID().getMostSignificantBits(),
        		answerCreationDTO.getStudentFullName(), answerCreationDTO.getAnswer(),
            answerCreationDTO.getElapsedTime(), answerCreationDTO.getScore(), question);
        return answerRepository.save(answer);
    }

    public List<AnswerDTO> getAllAnswers() {
        return answerRepository.findAll().stream()
            .map(AnswerDTO::new)
            .collect(Collectors.toList());
    }
    
    public Optional<Answer> findAnswerById(long id) {
        return answerRepository.findById(id);
    }
}
