package com.microservices.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  private final List<User> users = new ArrayList<>();

  @GetMapping
  public List<User> getAllUsers() {
    return users;
  }

  @PostMapping
  public ResponseEntity<String> addUser(@RequestBody User user) {
    // Validate user, encrypt password, etc.
    users.add(user);
    return ResponseEntity.ok("User added successfully!");
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    Optional<User> user = users.stream().filter(u -> u.getId_user().equals(id)).findFirst();
    return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
    for (User user : users) {
      if (user.getId_user().equals(id)) {
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword()); // Consider encryption
        return ResponseEntity.ok("User updated successfully!");
      }
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    users.removeIf(user -> user.getId_user().equals(id));
    return ResponseEntity.ok("User deleted successfully!");
  }
}
