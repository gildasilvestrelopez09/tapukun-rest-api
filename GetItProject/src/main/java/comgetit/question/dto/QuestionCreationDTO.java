package comgetit.question.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuestionCreationDTO {

    @NotBlank
    private String question;

    @NotBlank
    private String options;
    
    @NotBlank
    private String rightAnswer;
    
    @NotNull
    private int deadTime;

    @NotNull
    private Integer score;

    private Long parentId;

    public QuestionCreationDTO(@NotBlank String question, String options, String rightAnswer, int deadTime,
        Integer score,
        @NotNull Long parentId) {
        this.question = question;
        this.options = options;
        this.rightAnswer = rightAnswer;
        this.deadTime = deadTime;
        this.score = score;
        this.parentId = parentId;
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

    public Long getParentId() {
        return parentId;
    }
}
