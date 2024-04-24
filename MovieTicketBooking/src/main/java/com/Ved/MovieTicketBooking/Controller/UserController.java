package com.Ved.MovieTicketBooking.Controller;

import com.Ved.MovieTicketBooking.DTO.LoginRequest;
import com.Ved.MovieTicketBooking.Entity.User;
import com.Ved.MovieTicketBooking.Repository.UserRepo;
import com.Ved.MovieTicketBooking.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.helpers.CheckReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }



    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @PutMapping("/{id}/balance")
    public ResponseEntity<User> updateBalance(@PathVariable String id, @RequestBody String balance) {
        return userService.updateBalance(id, balance);
    }

    @DeleteMapping
    public void deleteAllUsers(){
        userService.deleteAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }



}
