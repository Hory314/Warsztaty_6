package pl.coderslab.tweeter.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.tweeter.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByLogin(String login);

    User findByEmail(String email);

    User findByLoginAndPassword(String login, String password);
}
