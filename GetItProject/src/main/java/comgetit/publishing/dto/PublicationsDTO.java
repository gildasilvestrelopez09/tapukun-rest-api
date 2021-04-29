package comgetit.publishing.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import comgetit.publishing.PublishingType;
import comgetit.workarea.WorkArea;

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
    
	public PublicationsDTO(Long id, PublishingType publishingType, WorkArea workArea, Integer tariff2, String address2,
			Integer timeRequiredOrOffered2, String description2) {
		this.adId = id;
		this.type = publishingType.name();
        this.workAreaName = workArea.getName();
        this.fee = tariff2;
        this.address = address2;
        this.requiredTime = timeRequiredOrOffered2;
        this.description = description2;
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
}
