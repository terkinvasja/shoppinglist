package by.kutsko.repository.datajpa;

import by.kutsko.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vasily on 27.01.2017.
 */
@Transactional(readOnly = true)
public interface CrudCategoryRepository extends JpaRepository<Category, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Category c WHERE c.id=:id AND c.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Override
    Category save(Category category);

    @Query("SELECT c FROM Category c WHERE c.user.id=:userId ORDER BY c.name ASC")
    List<Category> getAll(@Param("userId") int userId);
}
