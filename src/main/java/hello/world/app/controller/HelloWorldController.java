package hello.world.app.controller;

import hello.world.app.models.User;
import hello.world.app.service.CustomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {
    private final CustomService service;
    public HelloWorldController(CustomService service) {this.service = service;}

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok(service.getHello());
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return ResponseEntity.ok(service.addUser(user));
    }
}
