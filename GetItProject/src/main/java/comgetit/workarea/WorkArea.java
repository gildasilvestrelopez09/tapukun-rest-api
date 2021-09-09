package comgetit.workarea;

import comgetit.publication.Publication;
import comgetit.user.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class WorkArea implements Serializable {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "workArea")
    @JsonIgnore
    private List<Publication> publicationList;

    protected WorkArea() {
    }

    public WorkArea(Long id, String name, List<Publication> publicationList,
        List<User> users) {
        this.id = id;
        this.name = name;
        this.publicationList = publicationList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Publication> getPublicationList() {
        return publicationList;
    }
}
