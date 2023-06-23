package programmerzamannow.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import programmerzamannow.contact.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
}
