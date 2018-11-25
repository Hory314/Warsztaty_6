package pl.coderslab.tweeter.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private LocalDateTime created;

    @ManyToOne
    private User user;

    @ManyToOne
    private Tweet tweet;

}
