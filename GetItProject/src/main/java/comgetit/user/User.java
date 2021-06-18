package comgetit.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import comgetit.publication.Publication;
import comgetit.workarea.WorkArea;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column
    private Long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String phone;

    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    @Column
    private String address;

    @ManyToOne
    private WorkArea workArea;
 
    @Column
    private int score;

    @Column
    private String email;

    @Column
    @JsonIgnore
    private String password;
    
    private byte[] image;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Publication> publicationList;

    public User(Long id, String firstname, String lastname, String phone,
        Date birthdate, String address, WorkArea workArea, int score, String email,
        String password, String image) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.birthdate = birthdate;
        this.address = address;
        this.workArea = workArea;
        this.score = score;
        this.email = email;
        this.password = password;
        this.image = image.getBytes();
    }

    protected User() {
    }

    public String getId() {
        return id.toString();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public WorkArea getWorkArea() {
        return workArea;
    }
    
    public int getScore() {
        return score;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public byte[] getImage() {
    	return image;
    }

    public List<Publication> getList() {
        return publicationList;
    }
}
