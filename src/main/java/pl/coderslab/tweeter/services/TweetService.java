package pl.coderslab.tweeter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.tweeter.dal.repositories.TweetRepository;
import pl.coderslab.tweeter.dal.repositories.UserRepository;
import pl.coderslab.tweeter.domain.Tweet;
import pl.coderslab.tweeter.domain.User;
import pl.coderslab.tweeter.web.controllers.LoginController;
import pl.coderslab.tweeter.web.dtos.TweetDTO;
import pl.coderslab.tweeter.web.dtos.UserDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TweetService
{

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    public List<TweetDTO> getAllTweets()
    {
        List<Tweet> tweets = tweetRepository.findAllByOrderByCreatedDesc();
        List<TweetDTO> tweetsDTO = new ArrayList<>();
        tweets.forEach(t ->
        {
            TweetDTO tweetDTO = new TweetDTO();
            tweetDTO.setId(t.getId());
            tweetDTO.setCreated(t.getCreated());
            tweetDTO.setText(t.getText());
            tweetDTO.setUser(t.getUser());
            tweetsDTO.add(tweetDTO);
        });
        return tweetsDTO;
    }

    public void saveTweet(@Valid TweetDTO tweetDTO, HttpSession session)
    {
        Tweet tweet = new Tweet();
        tweet.setCreated(LocalDateTime.now());
        tweet.setText(tweetDTO.getText());

        UserDTO userDTO = (UserDTO) session.getAttribute(LoginController.LOGGED_USER_KEY);
        System.out.println(userDTO.toString());
        User user = userRepository.getOne(userDTO.getId());

        tweet.setUser(user);
        tweetRepository.save(tweet);
    }
}
