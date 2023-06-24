package programmerzamannow.contact.controller;

import org.springframework.web.bind.annotation.RestController;
import programmerzamannow.contact.service.ContactService;

@RestController
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
}
