package hello.world.app.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getHello() {
        return "hello world";
    }
}
