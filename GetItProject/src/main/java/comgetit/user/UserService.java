package comgetit.user;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comgetit.user.dto.UserDTO;
import comgetit.user.dto.UsersDTO;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public User createUser(final UserDTO userDTO) {        
        User user = new User(UUID.randomUUID().getMostSignificantBits(), userDTO.getFirstname(), userDTO.getLastname(),
        					 userDTO.getPhone(), userDTO.getBirthdate(),
        					 userDTO.getAddress(), userDTO.getIdWorkArea(),
        					 userDTO.getEmail(), userDTO.getPassword(), userDTO.getPublishingList());
        return userRepository.save(user);
    }
	
	public List<UsersDTO> getAllUsers() {
        return userRepository.findAll().stream()
            .map(user -> new UsersDTO(user.getId(), user.getFirstname(), 
            	 user.getLastname(), user.getPhone(), user.getBirthdate(), 
            	 user.getAddress(), user.getWorkArea(), user.getEmail(),
            	 user.getPassword()))
            		.collect(Collectors.toList());
    }
}
