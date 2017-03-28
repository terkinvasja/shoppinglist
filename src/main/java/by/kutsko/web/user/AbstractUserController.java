package by.kutsko.web.user;

import by.kutsko.domain.User;
import by.kutsko.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Vasili on 022 22.01.17.
 */
public abstract class AbstractUserController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractUserController.class);

    @Autowired
    private UserService service;

    public List<User> getAll() {
//        log.info("getAll");
        LOG.info("getAll Users");
        return service.getAll();
    }

    public User get(int id) {
        return service.get(id);
    }

    public User create(User user) {
        user.setId(null);
        LOG.info("create {}", user);
        return service.save(user);
    }

    public void delete(int id) {
/*        checkModificationAllowed(id);
        log.info("delete " + id);*/
        LOG.info("delete User {}", id);
        service.delete(id);
    }

    public void update(User user, int id) {
//        checkModificationAllowed(id);
        user.setId(id);
//        log.info("update " + user);
        LOG.info("update {}", user);
        service.update(user);
    }

    public User getByMail(String email) {
//        log.info("getByEmail " + email);
        LOG.info("getByEmail {}", email);
        return service.getByEmail(email);
    }
}
