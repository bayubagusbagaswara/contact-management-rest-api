package programmerzamannow.contact.service;

import programmerzamannow.contact.dto.ContactResponse;
import programmerzamannow.contact.dto.CreateContactRequest;
import programmerzamannow.contact.entity.User;

public interface ContactService {

    ContactResponse create(User currentUser, CreateContactRequest request);

    ContactResponse get(User user, String id);
}
