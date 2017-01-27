package by.kutsko.repository;

import by.kutsko.domain.Category;

import java.util.Collection;

/**
 * Created by vasily on 27.01.2017.
 */
public interface CategoryRepository {

    Category save(Category category, int userId);

    boolean delete(int id, int userId);

    Category get(int id, int userId);

    Collection<Category> getAll(int userId);
}
