package comgetit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comgetit.user.dto.UserDTO;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public Users createUser(final UserDTO userDTO) {        
        Users user = new Users();
        user.setFirstname(userDTO.getFirstname()); ;
        user.setLastname(userDTO.getLastname());
        user.setPhone(userDTO.getPhone());
        user.setBirthdate(userDTO.getBirthdate());
        user.setAddress(userDTO.getAddress());
        user.setIdWorkArea(userDTO.getIdWorkArea());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }
}
