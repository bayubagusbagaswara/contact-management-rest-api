package programmerzamannow.contact.service.impl;

import org.springframework.stereotype.Service;
import programmerzamannow.contact.repository.UserRepository;
import programmerzamannow.contact.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
