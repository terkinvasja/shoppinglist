package by.kutsko.repository.datajpa;

import by.kutsko.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vasily on 02.02.2017.
 */
@Transactional(readOnly = true)
public interface CrudProductRepository extends JpaRepository<Product, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.id=:id AND p.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Override
    Product save(Product category);

    @Query("SELECT p FROM Product p WHERE p.user.id=:userId ORDER BY p.name ASC")
    List<Product> getAll(@Param("userId") int userId);

    @Query("SELECT p FROM Product p WHERE p.user.id=:userId and p.category.id=:categoryId ORDER BY p.name ASC")
    List<Product> getWithCategory(@Param("categoryId") int categoryId, @Param("userId") int userId);
}
