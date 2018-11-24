package pl.coderslab.tweeter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.tweeter.services.TweetService;
import pl.coderslab.tweeter.web.dtos.LoginFormDTO;
import pl.coderslab.tweeter.web.dtos.TweetDTO;
import pl.coderslab.tweeter.web.dtos.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController
{
    @Autowired
    TweetService tweetService;

    @GetMapping
    public String prepareHomePage(Model model,
                                  @SessionAttribute(value = LoginController.LOGGED_USER_KEY, required = false) UserDTO loggedUser)
    {
        if (loggedUser != null)
        {
            model.addAttribute("loggedUser", loggedUser);
            model.addAttribute("tweets", tweetService.getAllTweets());
        }
        return "/index";
    }
}
