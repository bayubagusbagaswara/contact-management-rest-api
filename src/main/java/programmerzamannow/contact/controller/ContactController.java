package programmerzamannow.contact.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import programmerzamannow.contact.dto.ContactResponse;
import programmerzamannow.contact.dto.CreateContactRequest;
import programmerzamannow.contact.dto.WebResponse;
import programmerzamannow.contact.entity.User;
import programmerzamannow.contact.service.ContactService;

@RestController
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping(
            path = "/api/contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> create(User user, @RequestBody CreateContactRequest request) {
        ContactResponse contactResponse = contactService.create(user, request);
        return WebResponse.<ContactResponse>builder()
                .data(contactResponse)
                .build();
    }

}
