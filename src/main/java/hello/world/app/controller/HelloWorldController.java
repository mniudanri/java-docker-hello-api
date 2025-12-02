package hello.world.app.controller;

import hello.world.app.service.HelloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private final HelloService service;
    public HelloWorldController(HelloService service) {this.service = service;}

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok(service.getHello());
    }
}
