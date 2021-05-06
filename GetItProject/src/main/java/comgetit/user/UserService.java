package comgetit.user;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comgetit.publishing.PublishingType;
import comgetit.user.dto.UserDTO;
import comgetit.user.dto.UsersDTO;
import comgetit.workarea.WorkArea;
import comgetit.workarea.WorkAreaRepository;
import comgetit.workarea.exception.WorkAreNotFoundException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final WorkAreaRepository workAreaRepository;
	
    @Autowired
    public UserService(UserRepository userRepository, WorkAreaRepository workAreaRepository) {
        this.userRepository = userRepository;
        this.workAreaRepository = workAreaRepository;
    }
	
	public User createUser(final UserDTO userDTO) {  
	    WorkArea workAreaId = workAreaRepository.findById(userDTO.getWorkAreaId())
            .orElseThrow(WorkAreNotFoundException::new);
        User user = new User(UUID.randomUUID().getMostSignificantBits(),
                             userDTO.getFirstname(), userDTO.getLastname(),
                             userDTO.getPhone(), userDTO.getBirthdate(),
                             userDTO.getAddress(), workAreaId,
                             userDTO.getEmail(), userDTO.getPassword());
        return userRepository.save(user);
    }
	
    public List<UsersDTO> getAllUsers() {
        return userRepository.findAll().stream()
            .map(user -> new UsersDTO(user.getId(), user.getFirstname(), 
                 user.getLastname(), user.getPhone(), user.getBirthdate(), 
                 user.getAddress(), user.getWorkArea().getId(), user.getEmail()))
                 .collect(Collectors.toList());
    }
}
