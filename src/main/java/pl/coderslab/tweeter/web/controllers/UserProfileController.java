package pl.coderslab.tweeter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.tweeter.services.UserService;

@Controller
@RequestMapping("/user")
public class UserProfileController
{
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public String userProfile(@PathVariable Long id, Model model)
        {
        model.addAttribute("user",userService.getUser(id));
        return "user_profile";
    }
}
