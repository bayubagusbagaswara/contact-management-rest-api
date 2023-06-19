package programmerzamannow.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import programmerzamannow.contact.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
