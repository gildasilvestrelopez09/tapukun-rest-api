package comgetit.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import comgetit.user.dto.UserDTO;

@RestController
public class UserController {
	
	private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<Long> createUser(
        @RequestBody @Valid final UserDTO userDTO
    ) {
        Users user = userService.createUser(userDTO);
        return new ResponseEntity(user.getId(), HttpStatus.CREATED);
    }

}
