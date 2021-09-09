package comgetit.questionary.dto;

import comgetit.questionary.Questionary;
import comgetit.user.User;
import comgetit.user.dto.UserDTO;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuestionaryDTO {

    @NotNull
    private Long questionaryId;

    @NotBlank
    private String name;

    @NotNull
    private String description;

    private int deadTime;
    
    private String accessCode;

    @NotNull
    private UserDTO user;

    private Date createdAt;

    public QuestionaryDTO(final Questionary questionary) {
        this.questionaryId = questionary.getId();
        this.name = questionary.getName();
        this.description = questionary.getDescription();
        this.deadTime = questionary.getDeadTime();
        this.accessCode = questionary.getAccessCode();
        this.createdAt = questionary.getCreated();
        this.user = new UserDTO(questionary.getUser().getFirstname(),
        		questionary.getUser().getLastname(), questionary.getUser().getPhone(),
        		questionary.getUser().getBirthdate(), questionary.getUser().getAddress(),
        		questionary.getUser().getScore(), questionary.getUser().getEmail(),
        		questionary.getUser().getAddress());
    }

    public QuestionaryDTO(String name2, String description2, Integer deadTime2, Date created, User user2) {
		// TODO Auto-generated constructor stub
	}

	public Long getQuestionaryId() {
        return questionaryId;
    }

    public String name() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDeadTime() {
        return deadTime;
    }
    
    public String getAccessCode() {
        return accessCode;
    }
  
    public UserDTO getUser() {
        return user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
