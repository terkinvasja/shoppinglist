package by.kutsko.repository.datajpa;

import by.kutsko.domain.Category;
import by.kutsko.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vasily on 27.01.2017.
 */
@Repository
public class DataJpaCategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private CrudCategoryRepository crudRepository;

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Override
    public Category save(Category category, int userId) {
        if (!category.isNew() && get(category.getId(), userId) == null) {
            return null;
        }
        category.setUser(crudUserRepository.getOne(userId));
        return crudRepository.save(category);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudRepository.delete(id, userId) != 0;
    }

    @Override
    public Category get(int id, int userId) {
        Category category = crudRepository.findOne(id);
        return category != null && category.getUser().getId() == userId ? category : null;
    }

    @Override
    public List<Category> getAll(int userId) {
        return crudRepository.getAll(userId);
    }
}
