package by.kutsko.service;

import by.kutsko.domain.User;
import by.kutsko.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Vasili on 022 22.01.17.
 */
public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

//    void update(UserTo user);

    List<User> getAll();

    void update(User user);
}
