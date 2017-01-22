package by.kutsko.web.user;

import by.kutsko.domain.User;
import by.kutsko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Vasili on 022 22.01.17.
 */
public abstract class AbstractUserController {

    @Autowired
    private UserService service;

    public List<User> getAll() {
//        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        return service.get(id);
    }

    public User create(User user) {
        user.setId(null);
        return service.save(user);
    }

    public void delete(int id) {
/*        checkModificationAllowed(id);
        log.info("delete " + id);*/
        service.delete(id);
    }

    public void update(User user, int id) {
//        checkModificationAllowed(id);
        user.setId(id);
//        log.info("update " + user);
        service.update(user);
    }

    public User getByMail(String email) {
//        log.info("getByEmail " + email);
        return service.getByEmail(email);
    }
}
