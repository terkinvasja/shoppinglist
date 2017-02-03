package by.kutsko.service;

import by.kutsko.domain.Product;
import by.kutsko.repository.ProductRepository;
import by.kutsko.util.exception.ExceptionUtil;
import by.kutsko.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by vasily on 03.02.2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public Product save(Product product, int categoryId, int userId) {
        return repository.save(product, categoryId, userId);
    }

    @Override
    public Product update(Product product, int categoryId, int userId) throws NotFoundException {
        Assert.notNull(product, "product must not be null");
        return ExceptionUtil.checkNotFoundWithId(repository.save(product, categoryId, userId), product.getId());
    }

    @Override
    public void delete(int id, int userId) {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id, userId), id);
    }

    @Override
    public Product get(int id, int userId) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public List<Product> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public List<Product> getWithCategory(int categoryId, int userId) throws NotFoundException {
        return repository.getWithCategory(categoryId, userId);
    }
}
