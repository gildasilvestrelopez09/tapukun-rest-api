package comgetit.questionary;

import comgetit.questionary.dto.QuestionaryCreationDTO;
import comgetit.questionary.dto.QuestionaryDTO;
import comgetit.user.User;
import comgetit.user.UserRepository;
import comgetit.user.exception.UserNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionaryService {

    private final QuestionaryRepository questionaryRepository;

    private final UserRepository userRepository;

    @Autowired
    public QuestionaryService(QuestionaryRepository questionaryRepository
        , UserRepository userRepository) {
        this.questionaryRepository = questionaryRepository;
        this.userRepository = userRepository;
    }

    public Questionary createQuestionary(final QuestionaryCreationDTO questionaryCreationDTO) {
        User user = userRepository.findById(questionaryCreationDTO.getUserId())
            .orElseThrow(UserNotFoundException::new);
        
        Questionary questionary = new Questionary(UUID.randomUUID().getMostSignificantBits()
            , questionaryCreationDTO.getName(), questionaryCreationDTO.getDescription()
            , questionaryCreationDTO.getDeadTime(),  questionaryCreationDTO.getAccessCode() ,user, new Date());
        return questionaryRepository.save(questionary);
    }

    public List<QuestionaryDTO> getAllQuestionaries() {
        return questionaryRepository.findAll().stream()
            .map(QuestionaryDTO::new)
            .collect(Collectors.toList());
    }
    
    public Optional<Questionary> findQuestionaryById(long id) {
        return questionaryRepository.findById(id);
    }

    public Optional<Questionary> findQuestionaryByAccessCode(String code) {
        return questionaryRepository.findByAccessCode(code);
    }
}
