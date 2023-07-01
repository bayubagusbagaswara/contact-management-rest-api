package programmerzamannow.contact.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import programmerzamannow.contact.dto.AddressResponse;
import programmerzamannow.contact.dto.CreateAddressRequest;
import programmerzamannow.contact.dto.WebResponse;
import programmerzamannow.contact.entity.User;
import programmerzamannow.contact.service.AddressService;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(
            path = "/api/contacts/{contactId}/addresses"
    )
    public WebResponse<AddressResponse> create(User user,
                                               @RequestBody CreateAddressRequest request,
                                               @PathVariable("contactId") String contactId) {

        request.setContactId(contactId);
        AddressResponse addressResponse = addressService.create(user, request);
        return WebResponse.<AddressResponse>builder()
                .data(addressResponse)
                .build();
    }

}
