package programmerzamannow.contact.service.impl;

import org.springframework.stereotype.Service;
import programmerzamannow.contact.repository.UserRepository;
import programmerzamannow.contact.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
