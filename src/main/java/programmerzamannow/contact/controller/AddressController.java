package programmerzamannow.contact.controller;

import org.springframework.web.bind.annotation.RestController;
import programmerzamannow.contact.service.AddressService;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
}
