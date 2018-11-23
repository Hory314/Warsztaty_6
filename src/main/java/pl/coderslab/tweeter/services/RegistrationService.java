package pl.coderslab.tweeter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.tweeter.dal.repositories.UserRepository;
import pl.coderslab.tweeter.domain.User;
import pl.coderslab.tweeter.web.dtos.RegistrationFormDTO;

import javax.validation.Valid;

@Service
@Transactional
public class RegistrationService
{
    @Autowired
    UserRepository userRepository;

    public boolean checkLogin(String login)
    {
        if (login == null || login.isEmpty()) return false;

        User user = userRepository.findByLogin(login);
        return user == null;
    }

    public boolean checkEmail(String email)
    {
        if (email == null || email.isEmpty()) return false;

        User user = userRepository.findByEmail(email);
        return user == null;
    }

    public void registerUser(@Valid RegistrationFormDTO form)
    {
        User user = new User();
        user.setLogin(form.getLogin());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword()); //todo hash password
        user.setEnabled(true);
        userRepository.save(user);
    }
}
