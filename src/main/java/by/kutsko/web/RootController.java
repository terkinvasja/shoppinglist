package by.kutsko.web;

import by.kutsko.service.UserService;
import by.kutsko.web.user.AbstractUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Vasili on 022 22.02.17.
 */
@Controller
public class RootController extends AbstractUserController {

    @Autowired
    private UserService service;

/*    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(Model model) {
        model.addAttribute("users", service.getAll());
        return "index";
    }*/
}
