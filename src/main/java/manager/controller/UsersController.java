package manager.controller;

import manager.config.AppConfig;
import manager.model.User;
import manager.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.activation.DataHandler;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/", "list"})
    //@GetMapping(value = "/")
    public String indexPage(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "form";
    }

    @PostMapping({"", "/",})
    public String saveUser(@ModelAttribute("user") User user) {
        if(user.getId() == null) {
            userService.createUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edidtUserForm(@PathVariable(value = "id", required = true) long id, ModelMap model) {
        if (userService.getUserById(id) == null) {
            return "redirect:/users";
        }

        model.addAttribute("user", userService.getUserById(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id", required = true) long id, ModelMap model) {
        if(userService.getUserById(id) != null) {
            userService.deleteUserById(id);
        }
        return "redirect:/users";
    }
}
