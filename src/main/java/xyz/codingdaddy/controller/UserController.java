package xyz.codingdaddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.codingdaddy.domain.User;
import xyz.codingdaddy.repository.UserRepository;

/**
 * {@link User} REST controller
 *
 * @author serhiy
 */
@RestController
@RequestMapping(value = "/api")
@ResponseBody
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/user")
    public ResponseEntity<User> getUser(@RequestParam String username) {
        return userRepository.findByUsername(username).stream().findFirst()
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> newUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userRepository.save(user));
    }
}
