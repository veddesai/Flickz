package com.Ved.MovieTicketBooking.Repository;

import com.Ved.MovieTicketBooking.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {

    User findByUsername(String username);
    User findByEmail(String email);
}
