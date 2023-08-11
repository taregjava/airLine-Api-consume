package com.halfacode.travelagency.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  /*  private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserDetailsDTO userDetailsDTO) {
        User existingUser = userRepository.findByEmail(userDetailsDTO.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("Email already registered");
        }

        User newUser = new User();
        newUser.setEmail(userDetailsDTO.getEmail());
        // Set other user details
        return userRepository.save(newUser);
    }

    public User loginUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }*/
}