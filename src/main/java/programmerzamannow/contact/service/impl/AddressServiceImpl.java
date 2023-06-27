package programmerzamannow.contact.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmerzamannow.contact.dto.AddressResponse;
import programmerzamannow.contact.dto.CreateAddressRequest;
import programmerzamannow.contact.entity.User;
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

    @Transactional
    @Override
    public AddressResponse create(User user, CreateAddressRequest request) {
        return null;
    }
}
