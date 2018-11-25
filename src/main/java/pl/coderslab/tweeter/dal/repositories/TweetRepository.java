package pl.coderslab.tweeter.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.tweeter.domain.Tweet;
import pl.coderslab.tweeter.domain.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long>
{
    List<Tweet> findAllByOrderByCreatedDesc();

    List<Tweet> findByUserIdOrderByCreatedDesc(Long id);

    List<Tweet> findByUserOrderByCreatedDesc(User user);
}
