package comgetit.answer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import comgetit.question.Question;

@Entity
public class Answer {

	@Id
	@GeneratedValue
    private Long id;

    private String studentFullName;

    private String answer;
    
    private Integer elapsedTime;
    
    private Integer score;

    @ManyToOne
    @JsonIgnore
    private Question question;

    protected Answer() {
    }

    public Answer(Long id, String studentFullName, String answer, Integer elapsedTime,
        Integer score, Question question) {
        this.id = id;
        this.studentFullName = studentFullName;
        this.answer = answer;
        this.elapsedTime = elapsedTime;
        this.score = score;
        this.question = question;
    }

	public Long getId() {
        return id;
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

    public Question getQuestion() {
        return question;
    }
}
