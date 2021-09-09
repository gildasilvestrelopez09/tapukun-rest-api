package comgetit.question;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import comgetit.questionary.Questionary;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private String question;

    private String options;
    
    private String rightAnswer;
    
    private Integer deadTime;
    
    private Integer score;

    @ManyToOne
    @JsonIgnore
    private Questionary questionary;

    protected Question() {
    }

    public Question(Long id, String question, String options, String rightAnswer, Integer deadTime,
        Integer score, Questionary questionary) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.rightAnswer = rightAnswer;
        this.deadTime = deadTime;
        this.score = score;
        this.questionary = questionary;
    }

    public Long getId() {
        return id;
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
    
    public Integer getDeadTime() {
        return deadTime;
    }
    
    public Integer getScore() {
        return score;
    }

    public Questionary getQuestionary() {
        return questionary;
    }
}
