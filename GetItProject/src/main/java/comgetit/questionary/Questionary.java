package comgetit.questionary;

import comgetit.question.Question;
import comgetit.user.User;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Questionary {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;
    
    private Integer deadTime;
    
    private String accessCode;

    @ManyToOne
    @JsonIgnore
    private User user;

    private Date created = new Date();
    
    @OneToMany(mappedBy = "questionary")
    @JsonIgnore
    private List<Question> questionList;

    protected Questionary() {
    }

    public Questionary(Long id, String name, String description, Integer deadTime, String accessCode,
        User user, Date created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadTime = deadTime;
        this.accessCode = accessCode;
        this.user = user;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
    	return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Integer getDeadTime() {
        return deadTime;
    }
    
    public String getAccessCode() {
        return accessCode;
    }

    public User getUser() {
        return user;
    }

    public Date getCreated() {
        return created;
    }
    
    public List<Question> getList() {
        return questionList;
    }
}
