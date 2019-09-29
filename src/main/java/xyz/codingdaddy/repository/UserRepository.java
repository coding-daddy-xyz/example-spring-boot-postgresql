package xyz.codingdaddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.codingdaddy.domain.User;

import java.util.List;

/**
 * {@link User} database repository
 *
 * @author serhiy
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Returns the list of users from database filtered by username
     *
     * @param username to filter the users
     * @return the list of users matching the criteria
     */
    List<User> findByUsername(String username);
}
