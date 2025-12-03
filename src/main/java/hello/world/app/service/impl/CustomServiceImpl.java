package hello.world.app.service.impl;

import hello.world.app.models.User;
import hello.world.app.service.CustomService;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.List;

public class CustomServiceImpl implements CustomService {
    private final JdbcTemplate jdbcTemplate;

    public CustomServiceImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public String getHello() {
        return "Hello World";
    }

    @Override
    public List<User> getUsers() {
        String sql = "SELECT id, name, email FROM users";

        return jdbcTemplate.query(sql, (ResultSet rs, int row) -> {
            return new User(
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("id")
            );
        });
    }

    @Override
    public String addUser(User user) {
        String sql = "INSERT INTO users (name, email) VALUES(?, ?)";
        int id = jdbcTemplate.update(sql, user.getName(), user.getEmail());

        return "Successfully insert user data with id = " + id;
    }
}
