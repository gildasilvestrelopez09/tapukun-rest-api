package comgetit.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Users {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
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
	    
	    private Long idWorkArea;

	    @Column
	    private String email;

	    @Column
	    private String password;
	    
	    

		/*public User(Long id, String firstname, String lastname, String phone, Date birthdate, String address,
				Long idWorkArea, String email, String password) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.phone = phone;
			this.birthdate = birthdate;
			this.address = address;
			this.idWorkArea = idWorkArea;
			this.email = email;
			this.password = password;
		}*/

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Date getBirthdate() {
			return birthdate;
		}

		public void setBirthdate(Date birthdate) {
			this.birthdate = birthdate;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Long getIdWorkArea() {
			return idWorkArea;
		}

		public void setIdWorkArea(Long idWorkArea) {
			this.idWorkArea = idWorkArea;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    
	    

}
