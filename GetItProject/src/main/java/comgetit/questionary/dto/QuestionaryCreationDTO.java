package comgetit.questionary.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QuestionaryCreationDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 10, max = 250)
    private String description;
    
    @NotNull
    private int deadTime;
    
    @NotBlank
    private String accessCode;
    
    @NotNull
    private Long userId;

    public QuestionaryCreationDTO(@NotBlank String name,
        @NotBlank @Size(min = 10, max = 100) String description, int deadTime,
        @NotNull Long userId, @NotBlank String accessCode) {
        this.name = name;
        this.description = description;
        this.deadTime = deadTime;
        this.accessCode = accessCode;
        this.userId = userId;
    }

	public String getName() {
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
    
    public Long getUserId() {
        return userId;
    }
}
