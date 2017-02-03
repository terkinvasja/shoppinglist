package by.kutsko.web.product;

import by.kutsko.AuthorizedUser;
import by.kutsko.domain.Product;
import by.kutsko.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by vasily on 03.02.2017.
 */
public abstract class AbstractProductController {

    @Autowired
    ProductService service;

    public Product create(Product product, int categoryId) {
        product.setId(null);
        int userId = AuthorizedUser.id();
        return service.save(product, categoryId, userId);
    }

    public void update(Product product, int id, int categoryId) {
        product.setId(id);
        int userId = AuthorizedUser.id();
        service.update(product, categoryId, userId);
    }

    public void delete(int id) {
        int userId = AuthorizedUser.id();
        service.delete(id, userId);
    }

    public Product get(int id) {
        int userId = AuthorizedUser.id();
        return service.get(id, userId);
    }

    public List<Product> getAll() {
        int userId = AuthorizedUser.id();
        return service.getAll(userId);
    }

    public List<Product> getWithCategory(int categoryId) {
        int userId = AuthorizedUser.id();
        return service.getWithCategory(categoryId, userId);
    }
}
