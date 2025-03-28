package assgiment.ass.DAO;



import org.springframework.data.jpa.repository.JpaRepository;

import assgiment.ass.Model.*;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
