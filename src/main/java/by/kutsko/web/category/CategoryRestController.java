package by.kutsko.web.category;

import by.kutsko.domain.Category;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by vasily on 31.01.2017.
 */
@RestController
@RequestMapping(value = CategoryRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryRestController extends AbstractCategoryController {
    static final String REST_URL = "/rest/profile/category";

    @GetMapping
    public List<Category> getAll() {
        return super.getAll();
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable("id") int id){
        return super.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Category category, @PathVariable("id") int id) {
        super.update(category, id);
    }

}
