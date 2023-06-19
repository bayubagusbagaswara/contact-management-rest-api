package programmerzamannow.contact.service.impl;

import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import programmerzamannow.contact.dto.RegisterUserRequest;
import programmerzamannow.contact.repository.UserRepository;
import programmerzamannow.contact.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }


}
