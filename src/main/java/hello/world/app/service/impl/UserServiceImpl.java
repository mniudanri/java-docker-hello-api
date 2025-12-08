package hello.world.app.service.impl;

import hello.world.app.dto.UserDTO;
import hello.world.app.repository.UserRepository;
import hello.world.app.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) { this.repo = repo; }

    @Transactional(readOnly = true)
    public Optional<UserDTO> getUserById(long id) { return repo.findById(id); }

    @Transactional(readOnly = true)
    public List<UserDTO> getUsers(int page, int size, String sortBy, boolean asc) {
        return repo.getUsers(page, size, sortBy, asc);
    }

    @Transactional
    public long createUser(UserDTO dto) {
        Optional<Long> response = repo.insert(dto.email(), dto.name());
        return response.orElse(-1L);
    }
}
