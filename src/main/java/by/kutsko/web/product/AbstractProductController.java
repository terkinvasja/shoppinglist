package by.kutsko.web.product;

import by.kutsko.AuthorizedUser;
import by.kutsko.domain.Product;
import by.kutsko.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by vasily on 03.02.2017.
 */
public abstract class AbstractProductController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractProductController.class);

    @Autowired
    ProductService service;

    public Product create(Product product, int categoryId) {
        product.setId(null);
        int userId = AuthorizedUser.id();
        LOG.info("create {} for User {}", product, userId);
        return service.save(product, categoryId, userId);
    }

    public void update(Product product, int id, int categoryId) {
        product.setId(id);
        int userId = AuthorizedUser.id();
        LOG.info("update {} for User {}", product, userId);
        service.update(product, categoryId, userId);
    }

    public void delete(int id) {
        int userId = AuthorizedUser.id();
        LOG.info("delete product {} for User {}", id, userId);
        service.delete(id, userId);
    }

    public Product get(int id) {
        int userId = AuthorizedUser.id();
        LOG.info("get product {} for User {}", id, userId);
        return service.get(id, userId);
    }

    public List<Product> getAll() {
        int userId = AuthorizedUser.id();
        return service.getAll(userId);
    }

    public List<Product> getWithCategory(int categoryId) {
        int userId = AuthorizedUser.id();
        LOG.info("getWithCategory {} for User {}", categoryId, userId);
        return service.getWithCategory(categoryId, userId);
    }
}
