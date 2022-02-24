package com.cherrytechnologies.restdocker.controller.User;

import com.cherrytechnologies.restdocker.domain.User;
import com.cherrytechnologies.restdocker.services.User.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id){
        log.info("GET /api/v1/user/" + id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .location(URI.create("/api/v1/user/" + id))
                .body(userService.getUser(id));
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        log.info("POST /api/v1/user/");
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .location(URI.create("/api/v1/user/"))
                .body(userService.createUser(user));
    }
}
