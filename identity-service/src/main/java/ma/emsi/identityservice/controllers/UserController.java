package ma.emsi.identityservice.controllers;


import ma.emsi.identityservice.Entities.User;
import ma.emsi.identityservice.enums.Role;
import ma.emsi.identityservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/company/employee")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<User> addEmployee(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User userUpdate){
        return ResponseEntity.ok(userService.updateUser(userUpdate));
    }

    @PostMapping("/addRole/{empId}")
    public ResponseEntity<User> addRole(@RequestBody Role role,@PathVariable("empId") Long userId){
        return ResponseEntity.ok(userService.addRoleToUser(role,userId));
    }

    @PostMapping("/updateRole/{empId}")
    public ResponseEntity<User> UpdateRole(@RequestBody Role role,@PathVariable("empId") Long userId){
        return ResponseEntity.ok(userService.updateUserRole(role,userId));
    }

}
