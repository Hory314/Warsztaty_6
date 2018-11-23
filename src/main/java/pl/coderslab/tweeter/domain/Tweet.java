package pl.coderslab.tweeter.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tweets")
public class Tweet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT NOW()")
    private LocalDateTime created;

    @ManyToOne
    private User user;
}
