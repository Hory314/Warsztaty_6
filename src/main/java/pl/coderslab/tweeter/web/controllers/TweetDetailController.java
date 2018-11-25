package pl.coderslab.tweeter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.tweeter.services.TweetService;

@Controller
@RequestMapping("/tweet")
public class TweetDetailController
{
    @Autowired
    TweetService tweetService;

    @GetMapping("/{id}")
    public String tweetDetails(@PathVariable Long id, Model model)
    {
        model.addAttribute("tweet", tweetService.getTweet(id));
        return "tweet_details";
    }
}
