package comgetit.user.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTO {
	
	@NotBlank
	@NotNull
	@Size(min = 3, max = 50)
    private String firstname;
 	
	@NotNull
	@Size(min = 3, max = 50)
    private String lastname;
    
	@NotNull
	@Size(max = 50)
    private String phone;
    
	@NotNull
    private Date birthdate;
    
    private String address;
    
    private Long idWorkArea;

    @NotNull
    @Size(max = 50)
    private String email;

    @NotNull
    @Size(min = 8, max = 50)
    private String password;

	public UserDTO(@NotBlank @NotNull @Size(min = 3, max = 50) String firstname,
			@NotNull @Size(min = 3, max = 50) String lastname, @NotNull @Size(max = 50) String phone,
			@NotNull Date birthdate, String address, Long idWorkArea, @NotNull @Size(max = 50) String email,
			@NotNull @Size(min = 8, max = 50) String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.birthdate = birthdate;
		this.address = address;
		this.idWorkArea = idWorkArea;
		this.email = email;
		this.password = password;
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
