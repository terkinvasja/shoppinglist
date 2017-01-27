package by.kutsko.service;

import by.kutsko.domain.Category;
import by.kutsko.util.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by vasily on 27.01.2017.
 */
public interface CategoryService {

    Category save(Category category, int userId);

    Category update(Category category, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    Category get(int id, int userId) throws NotFoundException;

    Collection<Category>  getAll(int userId);
}
