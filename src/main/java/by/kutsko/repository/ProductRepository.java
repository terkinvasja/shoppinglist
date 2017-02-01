package by.kutsko.repository;

import by.kutsko.domain.Product;

import java.util.List;

/**
 * Created by Vasili on 001 01.02.17.
 */
public interface ProductRepository {

    Product save(Product product, int userId);

    boolean delete(int id, int userId);

    Product get(int id, int userId);

    List<Product> getAll(int userId);

    List<Product> getWithCategory(int categoryId, int userId);
}
