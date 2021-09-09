package comgetit.answer.dto;

import comgetit.answer.Answer;
import comgetit.question.Question;
import comgetit.question.dto.QuestionDTO;
import comgetit.questionary.Questionary;
import comgetit.questionary.dto.QuestionaryDTO;
import comgetit.user.dto.UserDTO;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;

public class AnswerDTO {

    @NotNull
    private Long answerId;

    @NotBlank
    private String studentFullName;

    @NotNull
    private String answer;
    
    private int elapsedTime;

    @NotNull
    private Integer score;

    private QuestionDTO question;

    public AnswerDTO(final Answer answer) {
        this.answerId = answer.getId();
        this.studentFullName = answer.getStudentFullName();
        this.answer = answer.getAnswer();
        this.elapsedTime = answer.getElapsedTime();
        this.score = answer.getScore();
        this.question = new QuestionDTO(answer.getQuestion().getQuestion(),
        		answer.getQuestion().getOptions(), answer.getQuestion().getRightAnswer(),
        		answer.getQuestion().getDeadTime(), answer.getQuestion().getScore(), answer.getQuestion().getQuestionary());
    }

    public Long getAnswerId() {
        return answerId;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public String getAnswer() {
        return answer;
    }
    
    public int getElapsedTime() {
        return elapsedTime;
    }
  
    public Integer getScore() {
        return score;
    }

    public QuestionDTO getQuestion() {
        return question;
    }
}
