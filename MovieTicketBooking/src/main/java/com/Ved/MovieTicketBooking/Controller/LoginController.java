package com.Ved.MovieTicketBooking.Controller;

import com.Ved.MovieTicketBooking.DTO.LoginRequest;
import com.Ved.MovieTicketBooking.Entity.User;
import com.Ved.MovieTicketBooking.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
public class LoginController {

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }


    @GetMapping
    public ResponseEntity<?> getLogin(@RequestParam String email) {
        return userService.getLogin(email);
    }

}
