package hello.world.app.service;

import hello.world.app.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public Optional<UserDTO> getUserById(long id);
    public List<UserDTO> getUsers(int page, int size, String sortBy, boolean asc);
    public long createUser(UserDTO dto);
}
