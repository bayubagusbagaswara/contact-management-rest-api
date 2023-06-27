package programmerzamannow.contact.service.impl;

import org.springframework.stereotype.Service;
import programmerzamannow.contact.repository.AddressRepository;
import programmerzamannow.contact.service.AddressService;
import programmerzamannow.contact.service.ValidationService;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final ValidationService validationService;

    public AddressServiceImpl(AddressRepository addressRepository, ValidationService validationService) {
        this.addressRepository = addressRepository;
        this.validationService = validationService;
    }
}
