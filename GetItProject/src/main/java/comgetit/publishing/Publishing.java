package comgetit.publishing;

import comgetit.user.User;
import comgetit.workarea.WorkArea;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Publishing {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private PublishingType publishingType;

    @ManyToOne
    @JsonIgnore
    private WorkArea workArea;

    private Integer tariff;

    private String address;

    private Integer timeRequiredOrOffered;

    private String description;

    @ManyToOne
    @JsonIgnore
    private User user;

    private Date created;

    protected Publishing() {
    }

    public Publishing(Long id, PublishingType publishingType, WorkArea workArea,
        Integer tariff, String address, Integer timeRequiredOrOffered, String description,
        User user, Date created) {
        this.id = id;
        this.publishingType = publishingType;
        this.workArea = workArea;
        this.tariff = tariff;
        this.address = address;
        this.timeRequiredOrOffered = timeRequiredOrOffered;
        this.description = description;
        this.user = user;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public PublishingType getPublishingType() {
        return publishingType;
    }

    public WorkArea getWorkArea() {
        return workArea;
    }

    public Integer getTariff() {
        return tariff;
    }

    public String getAddress() {
        return address;
    }

    public Integer getTimeRequiredOrOffered() {
        return timeRequiredOrOffered;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public Date getCreated() {
        return created;
    }
}
