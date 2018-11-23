package pl.coderslab.tweeter.web.dtos;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class LoginFormDTO
{
    @NotNull(message = "Należy podać login")
    @NotBlank(message = "Należy podać login")
    private String login;

    @NotNull(message = "Należy podać hasło")
    @NotBlank(message = "Należy podać hasło")
    private String password;

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "LoginFormDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginFormDTO that = (LoginFormDTO) o;
        return Objects.equals(login, that.login);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(login);
    }
}
