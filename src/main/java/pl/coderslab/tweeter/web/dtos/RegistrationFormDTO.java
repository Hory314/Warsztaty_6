package pl.coderslab.tweeter.web.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class RegistrationFormDTO
{
    @NotNull(message = "Uzupełnij login")
    @NotBlank(message = "Uzupełnij login")
    @Size(min = 3, max = 12, message = "Login musi zawierać od {min} do {max} znaków")
    private String login;

    @NotNull(message = "Uzupełnij e-mail")
    @NotBlank(message = "Uzupełnij e-mail")
    @Email(message = "E-mail jest niepoprawny")
    private String email;

    @NotNull(message = "Wpisz hasło")
    @NotBlank(message = "Wpisz hasło")
    private String password;

    @NotNull(message = "Wpisz ponownie hasło")
    @NotBlank(message = "Wpisz ponownie hasło")
    private String confirmedPassword;

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConfirmedPassword()
    {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword)
    {
        this.confirmedPassword = confirmedPassword;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationFormDTO that = (RegistrationFormDTO) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(confirmedPassword, that.confirmedPassword);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(login, email, password, confirmedPassword);
    }

    @Override
    public String toString() // todo usunac passwordy pozniej
    {
        return "RegistrationFormDTO{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmedPassword='" + confirmedPassword + '\'' +
                '}';
    }
}
