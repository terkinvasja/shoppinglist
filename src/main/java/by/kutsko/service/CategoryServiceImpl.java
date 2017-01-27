package by.kutsko.service;

import by.kutsko.domain.Category;
import by.kutsko.repository.CategoryRepository;
import by.kutsko.util.exception.ExceptionUtil;
import by.kutsko.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * Created by vasily on 27.01.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;

    @Override
    public Category save(Category category, int userId) {
        return repository.save(category, userId);
    }

    @Override
    public Category update(Category category, int userId) throws NotFoundException {
        Assert.notNull(category, "category must not be null");
        return ExceptionUtil.checkNotFoundWithId(repository.save(category, userId), category.getId());
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id, userId), id);
    }

    @Override
    public Category get(int id, int userId) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public Collection<Category> getAll(int userId) {
        return repository.getAll(userId);
    }
}
