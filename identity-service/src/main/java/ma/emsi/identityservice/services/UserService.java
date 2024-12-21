package ma.emsi.identityservice.services;


import ma.emsi.identityservice.enums.Role;
import ma.emsi.identityservice.Entities.User;
import ma.emsi.identityservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User addRoleToUser(Role role, Long userId){
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("user"+userId+" not exit"));
        user.setRole(role);
        return userRepository.save(user);

    }
    public User updateUser(User userUpdate){
        User user=userRepository.findById(userUpdate.getId()).orElseThrow(()->new RuntimeException("user"+userUpdate.getId()+" not exit"));
        user.setEmail(userUpdate.getEmail());
        user.setFirstname(userUpdate.getFirstname());
        user.setLastname(userUpdate.getLastname());
        user.setPhoneNumber(userUpdate.getPhoneNumber());
        user.setUsername(user.getUsername());
        return userRepository.save(user);
    }
    public User  updateUserRole(Role roleUpdate,Long userId){
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("user"+userId+" not exit"));
        user.setRole(roleUpdate);
        return userRepository.save(user);
    }

}
