package com.Ved.MovieTicketBooking.Service;

import com.Ved.MovieTicketBooking.DTO.LoginRequest;
import com.Ved.MovieTicketBooking.Entity.User;
import com.Ved.MovieTicketBooking.Repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.apache.juli.logging.Log;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return  ResponseEntity.ok(userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id)));
    }

    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(userRepository.findByUsername(username));
    }
    public ResponseEntity<User> createUser(@RequestBody @NotNull User userDetails) {
        String encodedPassword = passwordEncoder.encode(userDetails.getPassword());
        userDetails.setPassword(encodedPassword);
        userDetails.setBalance(5000);
        User savedUser = userRepository.save(userDetails);
        return ResponseEntity.ok(savedUser);
    }

    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }
        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

//            System.out.println(user.getEmail());
//            System.out.println(user.getUsername());

            return ResponseEntity.ok(user);
            
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
        }
    }

    public ResponseEntity<?> getLogin(@RequestParam String email) {


        User user = userRepository.findByEmail(email);
//        System.out.println(user.getEmail());
//        System.out.println(user.getUsername());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Null User");
        }
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody @NotNull User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        user.setUsername(userDetails.getUsername());
        user.setUserType(userDetails.getUserType());
        user.setBalance(userDetails.getBalance());
        return ResponseEntity.ok(userRepository.save(user));
    }
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
    public void deleteUser(@PathVariable UUID id) {
        userRepository.deleteById(id);
    }


    public ResponseEntity<User> updateBalance(String id, String balance) {
        int newBalance = Integer.parseInt(balance);
        User user = userRepository.findById(UUID.fromString(id)).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        user.setBalance(newBalance);
        return ResponseEntity.ok( userRepository.save(user));
    }
}
