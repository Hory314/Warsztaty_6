package pl.coderslab.tweeter.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.tweeter.web.dtos.UserDTO;

@Controller
@RequestMapping("/")
public class HomePageController
{

    @GetMapping
    public String prepareHomePage(Model model,
                                  @SessionAttribute(value = LoginController.LOGGED_USER_KEY, required = false) UserDTO loggedUser)
    {
        if(loggedUser != null)
        {
            model.addAttribute("loggedUser", loggedUser);
            model.addAttribute("tweets",null); // todo dostarczyc tweety
        }
        return "/index";
    }
}
