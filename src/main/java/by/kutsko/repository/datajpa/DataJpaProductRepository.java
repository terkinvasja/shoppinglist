package by.kutsko.repository.datajpa;

import by.kutsko.domain.Product;
import by.kutsko.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vasily on 02.02.2017.
 */
@Repository
public class DataJpaProductRepository implements ProductRepository {

    @Autowired
    private CrudProductRepository crudRepository;

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Autowired
    private CrudCategoryRepository crudCategoryRepository;

    @Override
    public Product save(Product product, int categoryId, int userId) {
        if (!product.isNew() && get(product.getId(), userId) == null) {
            return null;
        }
        product.setUser(crudUserRepository.getOne(userId));
        product.setCategory(crudCategoryRepository.getOne(categoryId));
        return crudRepository.save(product);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudRepository.delete(id, userId) != 0;
    }

    @Override
    public Product get(int id, int userId) {
        Product product = crudRepository.findOne(id);
        return product != null && product.getUser().getId() == userId ? product : null;
    }

    @Override
    public List<Product> getAll(int userId) {
        return crudRepository.getAll(userId);
    }

    @Override
    public List<Product> getWithCategory(int categoryId, int userId) {
        return crudRepository.getWithCategory(categoryId, userId);
    }
}
