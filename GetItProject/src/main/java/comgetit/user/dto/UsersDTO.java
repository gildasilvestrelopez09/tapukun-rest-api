package comgetit.user.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import comgetit.workarea.WorkArea;

public class UsersDTO {
	
	private Long id;
	
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
    
    private WorkArea workArea;

    @NotNull
    @Size(max = 50)
    private String email;

    @NotNull
    @Size(min = 8, max = 50)
    private String password;

	public UsersDTO(Long id, @NotBlank @NotNull @Size(min = 3, max = 50) String firstname,
			@NotNull @Size(min = 3, max = 50) String lastname, @NotNull @Size(max = 50) String phone,
			@NotNull Date birthdate, String address, WorkArea workArea, @NotNull @Size(max = 50) String email,
			@NotNull @Size(min = 8, max = 50) String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.birthdate = birthdate;
		this.address = address;
		this.workArea = workArea;
		this.email = email;
		this.password = password;
	}

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

	public WorkArea getWorkArea() {
		return workArea;
	}

	public void setWorkArea(WorkArea workArea) {
		this.workArea = workArea;
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
