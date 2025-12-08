package hello.world.app.repository;

import hello.world.app.dto.UserDTO;
import org.jooq.Field;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static hello.world.app.model.User.*;

@Repository
public class UserRepository extends BaseRepository {

    public UserRepository(org.jooq.DSLContext dsl) {
        super(dsl);
    }

    /** Simple find by id */
    public Optional<UserDTO> findById(long id) {
        return dsl.select(U_ID, U_EMAIL, U_NAME)
                .from(USERS)
                .where(U_ID.eq(id))
                .fetchOptional(rec -> new UserDTO(
                        rec.get(U_ID), rec.get(U_EMAIL), rec.get(U_NAME)
                ));
    }

    /** Dynamic filter + pagination + sorting */
    public List<UserDTO> getUsers(int page, int size, String sortBy, boolean asc) {

//        Condition condition = alwaysTrue();
//        condition = andLikeIgnoreCase(condition, U_EMAIL, emailContains);

        Field<String> sortField = switch (sortBy) {
            case "email"     -> U_EMAIL;
            case "name"      -> U_NAME;
            default          -> null;
        };

        return dsl.select(U_ID, U_EMAIL, U_NAME)
                .from(USERS)
//                .where(condition)
                .orderBy(sort(sortField, asc))
                .offset(offset(page, size))
                .limit(size)
                .fetch(rec -> new UserDTO(
                        rec.get(U_ID), rec.get(U_EMAIL), rec.get(U_NAME)
                ));
    }

    /** Insert with returning id */
    @Transactional
    public Optional<Long> insert(String email, String name) {
        return dsl.insertInto(USERS)
                .columns(U_EMAIL, U_NAME)
                .values(email, name)
                .returningResult(U_ID)
                .fetchOptional(U_ID);
    }
}
