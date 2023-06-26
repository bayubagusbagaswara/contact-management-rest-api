package programmerzamannow.contact.service;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import programmerzamannow.contact.dto.ContactResponse;
import programmerzamannow.contact.dto.CreateContactRequest;
import programmerzamannow.contact.dto.SearchContactRequest;
import programmerzamannow.contact.dto.UpdateContactRequest;
import programmerzamannow.contact.entity.User;

public interface ContactService {

    ContactResponse create(User currentUser, CreateContactRequest request);

    ContactResponse get(User user, String id);

    ContactResponse update(User user, UpdateContactRequest request);

    void delete(User user, String contactId);

    Page<ContactResponse> search(User user, SearchContactRequest request);
}
