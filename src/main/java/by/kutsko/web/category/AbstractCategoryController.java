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
}
