package comgetit.question.dto;

import comgetit.question.Question;
import comgetit.questionary.Questionary;
import comgetit.questionary.dto.QuestionaryDTO;
import comgetit.user.dto.UserDTO;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;

public class QuestionDTO {

    @NotNull
    private Long questionId;

    @NotBlank
    private String question;

    @NotNull
    private String options;

    private String rightAnswer;
    
    private int deadTime;

    @NotNull
    private Integer score;

    private QuestionaryDTO questionary;

    public QuestionDTO(final Question question) {
        this.questionId = question.getId();
        this.question = question.getQuestion();
        this.options = question.getOptions();
        this.rightAnswer = question.getRightAnswer();
        this.deadTime = question.getDeadTime();
        this.score = question.getScore();
        this.questionary = new QuestionaryDTO(question.getQuestionary().getName(),
        		question.getQuestionary().getDescription(), question.getQuestionary().getDeadTime(),
        		question.getQuestionary().getCreated(), question.getQuestionary().getUser());
    }

    public QuestionDTO(String question2, String options2, String rightAnswer2, Integer deadTime2, Integer score2,
			Questionary questionary2) {
		// TODO Auto-generated constructor stub
	}

	public Long getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptions() {
        return options;
    }
    
    public String getRightAnswer() {
    	return rightAnswer;
    }
    
    public int getDeadTime() {
        return deadTime;
    }
  
    public Integer getScore() {
        return score;
    }

    public QuestionaryDTO getQuestionary() {
        return questionary;
    }
}
