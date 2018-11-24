package pl.coderslab.tweeter.web.dtos;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.tweeter.domain.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

public class TweetDTO
{
    private Long id;

    private LocalDateTime created;

    @NotNull(message = "Wpisz treść")
    @NotEmpty(message = "Wpisz treść")
    @Size(max = 160, message = "Wpis może zawierać maksymalnie 160 znaków")
    private String text;

    private User user;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public LocalDateTime getCreated()
    {
        return created;
    }

    public void setCreated(LocalDateTime created)
    {
        this.created = created;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "TweetDTO{" +
                "id=" + id +
                ", created=" + created +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TweetDTO tweetDTO = (TweetDTO) o;
        return Objects.equals(id, tweetDTO.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
