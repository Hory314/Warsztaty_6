package pl.coderslab.tweeter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.tweeter.services.TweetService;
import pl.coderslab.tweeter.web.dtos.TweetDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/create")
public class TweetAddController
{
    @Autowired
    TweetService tweetService;

    @GetMapping
    public String prepareNewTweet(Model model)
    {
        model.addAttribute("newTweet", new TweetDTO());
        return "tweet_form";
    }

    @PostMapping
    public String addTweet(@ModelAttribute("newTweet") @Valid TweetDTO tweetDTO, BindingResult bindingResult, HttpSession session)
    {
        if (bindingResult.hasErrors())
        {
            return "tweet_form";
        }

        tweetService.saveTweet(tweetDTO, session);
        return "redirect:/";
    }
}
