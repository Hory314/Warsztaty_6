package pl.coderslab.tweeter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.tweeter.dal.repositories.UserRepository;
import pl.coderslab.tweeter.domain.User;
import pl.coderslab.tweeter.web.dtos.UserDTO;

@Service
@Transactional
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public UserDTO getUser(Long id)
    {
        User user = userRepository.findOne(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setEmail(user.getEmail());
        user.getTweets().size(); // lazy load
        userDTO.setTweets(user.getTweets());

        return userDTO;
    }
}
