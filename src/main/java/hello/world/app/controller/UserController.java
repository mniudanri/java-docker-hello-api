package hello.world.app.controller;


import hello.world.app.dto.UserDTO;
import hello.world.app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService service;
    public UserController(UserService service) {this.service = service;}
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(service.getUsers(0, 100, "name", true));
    }

    @PostMapping("/users")
    public ResponseEntity<Long> addUser(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(service.createUser(dto));
    }
}
