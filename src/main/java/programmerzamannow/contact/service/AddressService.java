package programmerzamannow.contact.service;

import programmerzamannow.contact.dto.AddressResponse;
import programmerzamannow.contact.dto.CreateAddressRequest;
import programmerzamannow.contact.entity.User;

public interface AddressService {

    AddressResponse create(User user, CreateAddressRequest request);

    AddressResponse get(User user, String contactId, String addressId);
}
