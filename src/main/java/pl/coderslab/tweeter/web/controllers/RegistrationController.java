package pl.coderslab.tweeter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.tweeter.services.RegistrationService;
import pl.coderslab.tweeter.web.dtos.RegistrationFormDTO;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController
{
    @Autowired
    RegistrationService registrationService;

    @GetMapping
    public String prepareRegistrationForm(Model model)
    {
        model.addAttribute("registrationFormData", new RegistrationFormDTO());
        return "registration";
    }

    @PostMapping
    public String register(@ModelAttribute("registrationFormData") @Valid RegistrationFormDTO form, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "registration";
        }

        if (!checkPasswords(form))
        {
            bindingResult.rejectValue("confirmedPassword", "", "Hasła muszą być zgodne");
            return "/registration";
        }

        boolean isLoginValid = registrationService.checkLogin(form.getLogin());
        if (!isLoginValid)
        {
            bindingResult.rejectValue("login", "", "Login jest zajęty");
            return "/registration";
        }

        boolean isEmailValid = registrationService.checkEmail(form.getEmail());
        if (!isEmailValid)
        {
            bindingResult.rejectValue("email", "", "Email już występuje w systemie");
            return "/registration";
        }

        registrationService.registerUser(form);
        return "/registration-success";
    }

    private boolean checkPasswords(RegistrationFormDTO form)
    {
        return form.getPassword().equals(form.getConfirmedPassword());
    }
}
