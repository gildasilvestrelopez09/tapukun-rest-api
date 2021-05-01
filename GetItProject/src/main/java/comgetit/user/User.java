package comgetit.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "Users")
public class User {
	 	@Id
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
	    
	    

		public User(Long id, String firstname, String lastname, String phone, Date birthdate, String address,
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
		}

		protected User() {}

		public Long getId() {
			return id;
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


		public Long getIdWorkArea() {
			return idWorkArea;
		}


		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}
}
