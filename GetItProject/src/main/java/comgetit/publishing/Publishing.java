package comgetit.publishing;

import comgetit.workarea.WorkArea;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Publishing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PublishingType publishingType;

    @ManyToOne
    private WorkArea workArea;

    private Integer tariff;

    private String address;

    private Integer timeRequiredOrOffered;

    private TimeType timeType;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PublishingType getPublishingType() {
        return publishingType;
    }

    public void setPublishingType(PublishingType publishingType) {
        this.publishingType = publishingType;
    }

    public TimeType getTimeType() {
        return timeType;
    }

    public void setTimeType(TimeType timeType) {
        this.timeType = timeType;
    }

    public WorkArea getWorkArea() {
        return workArea;
    }

    public void setWorkArea(WorkArea workArea) {
        this.workArea = workArea;
    }

    public Integer getTariff() {
        return tariff;
    }

    public void setTariff(Integer tariff) {
        this.tariff = tariff;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTimeRequiredOrOffered() {
        return timeRequiredOrOffered;
    }

    public void setTimeRequiredOrOffered(Integer timeRequiredOrOffered) {
        this.timeRequiredOrOffered = timeRequiredOrOffered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
