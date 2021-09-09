package comgetit.answer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AnswerCreationDTO {

    @NotBlank
    private String studentFullName;

    @NotBlank
    private String answer;
    
    @NotNull
    private Integer elapsedTime;

    @NotNull
    private Integer score;

    private Long questionId;

    public AnswerCreationDTO(@NotBlank String studentFullName, String answer, Integer elapsedTime,
        Integer score,
        @NotNull Long questionId) {
        this.studentFullName = studentFullName;
        this.answer = answer;
        this.elapsedTime = elapsedTime;
        this.score = score;
        this.questionId = questionId;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public String getAnswer() {
        return answer;
    }
    
    public Integer getElapsedTime() {
        return elapsedTime;
    }
  
    public Integer getScore() {
        return score;
    }

    public Long getQuestionId() {
        return questionId;
    }
}
