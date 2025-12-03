package hello.world.app.service;


import hello.world.app.models.User;

import java.util.List;

public interface CustomService {
    public String getHello();

    public List<User> getUsers();

    public String addUser(User user);
}
