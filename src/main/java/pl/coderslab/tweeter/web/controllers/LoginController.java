package pl.coderslab.tweeter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.tweeter.services.LoginService;
import pl.coderslab.tweeter.web.dtos.LoginFormDTO;
import pl.coderslab.tweeter.web.dtos.UserDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController
{
    public static final String LOGGED_USER_KEY = "logged-user";

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String prepareLoginForm(Model model)
    {
        model.addAttribute("loginFormData", new LoginFormDTO());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginFormData") @Valid LoginFormDTO form, BindingResult bindingResult, HttpSession session)
    {
        if (bindingResult.hasErrors())
        {
            return "login";
        }

        boolean validCredentials = loginService.checkCredentials(form.getLogin(), form.getPassword());
        if (!validCredentials)
        {
            bindingResult.rejectValue("login", "", "Login i/lub hasło niepoprawne");
            return "login";
        }

        UserDTO user = loginService.login(form.getLogin(), form.getPassword());
        session.setAttribute(LOGGED_USER_KEY, user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/";
    }
}
