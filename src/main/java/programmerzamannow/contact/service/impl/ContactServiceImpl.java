package programmerzamannow.contact.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import programmerzamannow.contact.dto.ContactResponse;
import programmerzamannow.contact.dto.CreateContactRequest;
import programmerzamannow.contact.dto.UpdateContactRequest;
import programmerzamannow.contact.entity.Contact;
import programmerzamannow.contact.entity.User;
import programmerzamannow.contact.repository.ContactRepository;
import programmerzamannow.contact.service.ContactService;
import programmerzamannow.contact.service.ValidationService;

import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ValidationService validationService;

    public ContactServiceImpl(ContactRepository contactRepository, ValidationService validationService) {
        this.contactRepository = contactRepository;
        this.validationService = validationService;
    }

    @Transactional
    @Override
    public ContactResponse create(User currentUser, CreateContactRequest request) {
        validationService.validate(request);

        Contact contact = new Contact();
        contact.setId(UUID.randomUUID().toString());
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        contact.setUser(currentUser);

        contactRepository.save(contact);

        return toContactResponse(contact);
    }

    @Transactional(readOnly = true)
    @Override
    public ContactResponse get(User user, String id) {
        Contact contact = contactRepository.findFirstByUserAndId(user, id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
        return toContactResponse(contact);
    }

    @Transactional
    @Override
    public ContactResponse update(User user, UpdateContactRequest request) {
        validationService.validate(request);

        Contact contact = contactRepository.findFirstByUserAndId(user, request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));

        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        contactRepository.save(contact);

        return toContactResponse(contact);
    }

    private ContactResponse toContactResponse(Contact contact) {
        return ContactResponse.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .build();
    }

}
