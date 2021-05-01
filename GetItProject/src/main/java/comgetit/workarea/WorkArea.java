package comgetit.workarea;

import comgetit.publishing.Publishing;
import comgetit.user.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WorkArea implements Serializable {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "workArea")
    private List<Publishing> publishingList;

    @OneToMany(mappedBy = "workArea")
    private List<User> users;

    protected WorkArea() {
    }

    public WorkArea(Long id, String name, List<Publishing> publishingList,
        List<User> users) {
        this.id = id;
        this.name = name;
        this.publishingList = publishingList;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Publishing> getPublishingList() {
        return publishingList;
    }

    public List<User> getUsers() {
        return users;
    }
}
