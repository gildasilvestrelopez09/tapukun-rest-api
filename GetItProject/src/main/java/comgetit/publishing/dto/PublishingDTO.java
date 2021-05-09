package comgetit.publishing.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PublishingDTO {

    @NotBlank
    private String typePublishing;

    @NotNull
    private Long workAreaId;

    private int tariff;

    @Size(min = 10, max = 50)
    private String address;

    private int timeRequiredOrOffered;

    @NotBlank
    @Size(min = 10, max = 100)
    private String description;

    @NotNull
    private Long userId;

    public PublishingDTO(@NotBlank String typePublishing,
        @NotNull Long workAreaId, int tariff,
        @Size(min = 10, max = 50) String address, int timeRequiredOrOffered,
        @NotBlank @Size(min = 10, max = 100) String description,
        @NotNull Long userId) {
        this.typePublishing = typePublishing;
        this.workAreaId = workAreaId;
        this.tariff = tariff;
        this.address = address;
        this.timeRequiredOrOffered = timeRequiredOrOffered;
        this.description = description;
        this.userId = userId;
    }

	public String getTypePublishing() {
        return typePublishing;
    }

    public Long getWorkAreaId() {
        return workAreaId;
    }

    public int getTariff() {
        return tariff;
    }

    public String getAddress() {
        return address;
    }

    public int getTimeRequiredOrOffered() {
        return timeRequiredOrOffered;
    }

    public String getDescription() {
        return description;
    }

    public Long getUserId() {
        return userId;
    }
}
