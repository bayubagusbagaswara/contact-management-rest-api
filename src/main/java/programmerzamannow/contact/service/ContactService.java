package programmerzamannow.contact.service;

import programmerzamannow.contact.dto.ContactResponse;
import programmerzamannow.contact.dto.CreateContactRequest;

public interface ContactService {

    ContactResponse create(CreateContactRequest request);
}
