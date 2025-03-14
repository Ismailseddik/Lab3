package com.example.demo.User;

import com.example.demo.User.dto.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    private final UserService userService;

public UserController(UserService userService){
    this.userService = userService;
}
    @GetMapping()
    public List<User> getUsers(){
    return this.userService.getUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return this.userService.findUserById(id);
    }
    @PostMapping()
    public User createUser(@RequestBody CreateUserDTO userdata) {
        return this.userService.createUser(userdata);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        this.userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id,@RequestBody CreateUserDTO userdata){
    this.userService.updateUser(id,userdata);
        return null;
    }


}
