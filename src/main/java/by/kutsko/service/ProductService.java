package by.kutsko.service;

import by.kutsko.domain.Product;
import by.kutsko.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Vasili on 001 01.02.17.
 */
public interface ProductService {

    Product save(Product product, int categoryId, int userId);

    Product update(Product product, int categoryId, int userId) throws NotFoundException;

    void delete(int id, int userId);

    Product get(int id, int userId) throws NotFoundException;

    List<Product> getAll(int userId);

    List<Product> getWithCategory(int categoryId, int userId) throws NotFoundException;
}
