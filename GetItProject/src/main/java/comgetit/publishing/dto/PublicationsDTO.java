package comgetit.publishing.dto;

import comgetit.publishing.Publishing;
import comgetit.user.dto.UserDTO;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PublicationsDTO {

    @NotNull
    private Long adId;

    @NotBlank
    private String type;

    @NotNull
    private String workAreaName;

    private int fee;

    @Size(min = 10, max = 50)
    private String address;

    private int requiredTime;

    @NotBlank
    @Size(min = 10, max = 100)
    private String description;

    @NotNull
    private UserDTO user;

    private Date createdAt;

    public PublicationsDTO(final Publishing publishing) {
        this.adId = publishing.getId();
        this.type = publishing.getPublishingType().name();
        this.workAreaName = publishing.getWorkArea().getName();
        this.fee = publishing.getTariff();
        this.address = publishing.getAddress();
        this.requiredTime = publishing.getTimeRequiredOrOffered();
        this.description = publishing.getDescription();
        this.createdAt = publishing.getCreated();
        this.user = new UserDTO(publishing.getUser().getFirstname(),
            publishing.getUser().getLastname()
            , publishing.getUser().getPhone(), publishing.getUser().getBirthdate()
            , publishing.getUser().getAddress()
            , publishing.getUser().getWorkArea().getId(), publishing.getUser().getEmail()
            , publishing.getUser().getAddress());
    }

    public Long getAdId() {
        return adId;
    }

    public String getType() {
        return type;
    }

    public String getWorkAreaName() {
        return workAreaName;
    }

    public int getFee() {
        return fee;
    }

    public String getAddress() {
        return address;
    }

    public int getRequiredTime() {
        return requiredTime;
    }

    public String getDescription() {
        return description;
    }

    public UserDTO getUser() {
        return user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
