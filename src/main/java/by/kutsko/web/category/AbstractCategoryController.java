package by.kutsko.web.category;

import by.kutsko.AuthorizedUser;
import by.kutsko.domain.Category;
import by.kutsko.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Vasili on 029 29.01.17.
 */
public abstract class AbstractCategoryController {

    @Autowired
    private CategoryService service;

    public List<Category> getAll() {
        int userId = AuthorizedUser.id();
        return service.getAll(userId);
    }

    public Category get(int id) {
        int userId = AuthorizedUser.id();
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = AuthorizedUser.id();
        service.delete(id, userId);
    }

    public Category create(Category category) {
        category.setId(null);
        int userId = AuthorizedUser.id();
        return service.save(category, userId);
    }

    public void update(Category category, int id) {
        category.setId(id);
        int userId = AuthorizedUser.id();
        service.update(category, id);
    }
}
