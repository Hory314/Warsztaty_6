package pl.coderslab.tweeter.web.dtos;

import pl.coderslab.tweeter.domain.Tweet;

import java.util.List;
import java.util.Objects;

public class UserDTO
{
    private Long id;
    private String login;
    private String email;
    private List<Tweet> tweets;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

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

    public List<Tweet> getTweets()
    {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets)
    {
        this.tweets = tweets;
    }

    @Override
    public String toString()
    {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) &&
                Objects.equals(login, userDTO.login) &&
                Objects.equals(email, userDTO.email);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, login, email);
    }
}
