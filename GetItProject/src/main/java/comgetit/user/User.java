package comgetit.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import comgetit.publication.Publication;
import comgetit.role.Role;
import comgetit.workarea.WorkArea;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Users")
public class User implements UserDetails {

    @Id
    @Column
    @GeneratedValue
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
 
    @Column
    private int score;

    @Column
    private String email;

    @Column
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Publication> publicationList;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "User_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "Role_id", referencedColumnName = "id"))
    private List<Role> authorities;

    public User(Long id, String firstname, String lastname, String phone,
        Date birthdate, String address, int score, String email,
        String password, List<Role> authorities) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.birthdate = birthdate;
        this.address = address;
        this.score = score;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
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
    
    public int getScore() {
        return score;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<Role> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public List<Publication> getList() {
        return publicationList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
