package programmerzamannow.contact.service.impl;

import org.springframework.stereotype.Service;
import programmerzamannow.contact.repository.ContactRepository;
import programmerzamannow.contact.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
}
