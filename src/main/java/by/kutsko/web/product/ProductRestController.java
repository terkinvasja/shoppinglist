package by.kutsko.web.product;

import by.kutsko.domain.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by vasily on 03.02.2017.
 */
@RestController
@RequestMapping(value = ProductRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductRestController extends AbstractProductController {
    static final String REST_URL = "/rest/profile/product";

    @GetMapping
    public List<Product> getAll() {
        return super.getAll();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") int id){
        return super.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Product product, @PathVariable("id") int id, @PathVariable("categoryId") int categoryId) {
        super.update(product, id, categoryId);
    }
}
