package programmerzamannow.contact.service.impl;

import org.springframework.stereotype.Service;
import programmerzamannow.contact.repository.UserRepository;
import programmerzamannow.contact.service.AuthService;
import programmerzamannow.contact.service.ValidationService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ValidationService validationService;

    public AuthServiceImpl(UserRepository userRepository, ValidationService validationService) {
        this.userRepository = userRepository;
        this.validationService = validationService;
    }

}
