package by.kutsko.repository;

import by.kutsko.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vasili on 020 20.01.17.
 */
public interface UserRepository {

    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();
}
