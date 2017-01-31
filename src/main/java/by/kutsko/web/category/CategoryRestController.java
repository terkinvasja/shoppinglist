package by.kutsko.web.category;

import by.kutsko.domain.Category;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
