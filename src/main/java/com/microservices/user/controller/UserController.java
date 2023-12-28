package com.microservices.user.controller;




import com.microservices.user.model.User;
import com.microservices.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private IUserService userService;

  @GetMapping("")
  public ResponseEntity<?> getAllUsers() {
    return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
  }

  @PostMapping("/save")
  public ResponseEntity<?> addUser(@RequestBody User user) {
    // Assigning ID (for demo purposes)
    var savedUser = userService.save(user);

    return new ResponseEntity<>(savedUser, HttpStatus.OK);
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<?> getUserById(@PathVariable Long id) {
    return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
  }

  @PutMapping("/update")
  public ResponseEntity<?> updateUser(@RequestBody User updatedUser) {
    return new ResponseEntity<>(userService.update(updatedUser), HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    // update car availability
    // interaction with car service
    userService.deleteById(id);
    return ResponseEntity.ok("User deleted successfully!");
  }
}
