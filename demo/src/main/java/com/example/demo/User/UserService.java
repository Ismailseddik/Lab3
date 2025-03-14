package com.example.demo.User;

import com.example.demo.User.dto.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private final UserRepositroy userRepository;

    public UserService(UserRepositroy userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }
    public User createUser(CreateUserDTO userData){
        User user = new User(
                userData.getEmail(),
                userData.getUsername(),
                userData.getPassword(),
                userData.getPhoneNumber()
        );
        return  this.userRepository.save(user);
    }
    public User findUserById(Integer id) {
        return this.userRepository.findById(id).orElse(null);
    }
    public User updateUser(Integer id, CreateUserDTO userData) {
        User existingUser = this.userRepository.findById(id).orElse(null);

        // Update user properties
        if(existingUser != null){
            existingUser.setEmail(userData.getEmail());
            existingUser.setUsername(userData.getUsername());
            existingUser.setPassword(userData.getPassword());
            existingUser.setPhoneNumber(userData.getPhoneNumber());
        }
        return this.userRepository.save(existingUser);
    }
    public void deleteUser(Integer id) {
        if (this.userRepository.existsById(id)) {
            this.userRepository.deleteById(id);
        }
    }
}
