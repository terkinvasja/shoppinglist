package by.kutsko;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vasili on 020 20.01.17.
 */
@RestController
@RequestMapping(value = "/hello")
public class DemoController {

    @RequestMapping(method = RequestMethod.GET)
    public String halloWorld() {
        return "Hello World!";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String halloName(@PathVariable("name") String name) {
        return "Hello, " + name + "!";
    }

}
