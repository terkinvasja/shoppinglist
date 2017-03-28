package by.kutsko.web.category;

import by.kutsko.AuthorizedUser;
import by.kutsko.domain.Category;
import by.kutsko.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Vasili on 029 29.01.17.
 */
public abstract class AbstractCategoryController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractCategoryController.class);

    @Autowired
    private CategoryService service;

    public List<Category> getAll() {
        int userId = AuthorizedUser.id();
        LOG.info("getAll category for User {}", userId);
        return service.getAll(userId);
    }

    public Category get(int id) {
        int userId = AuthorizedUser.id();
        LOG.info("get category {} for User {}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = AuthorizedUser.id();
        LOG.info("delete category {} for User {}", id, userId);
        service.delete(id, userId);
    }

    public Category create(Category category) {
        category.setId(null);
        int userId = AuthorizedUser.id();
        LOG.info("create {} for User {}", category, userId);
        return service.save(category, userId);
    }

    public void update(Category category, int id) {
        category.setId(id);
        int userId = AuthorizedUser.id();
        LOG.info("update {} for User {}", category, userId);
        service.update(category, id);
    }
}
