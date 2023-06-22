package programmerzamannow.contact.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import programmerzamannow.contact.dto.RegisterUserRequest;
import programmerzamannow.contact.dto.UpdateUserRequest;
import programmerzamannow.contact.dto.UserResponse;
import programmerzamannow.contact.entity.User;
import programmerzamannow.contact.repository.UserRepository;
import programmerzamannow.contact.security.BCrypt;
import programmerzamannow.contact.service.UserService;
import programmerzamannow.contact.service.ValidationService;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ValidationService validationService;

    public UserServiceImpl(UserRepository userRepository, ValidationService validationService) {
        this.userRepository = userRepository;
        this.validationService = validationService;
    }

    @Transactional
    @Override
    public void register(RegisterUserRequest registerUserRequest) {
        validationService.validate(registerUserRequest);

        if (userRepository.existsById(registerUserRequest.getUsername())) {
            // user is already exist
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already register");
        }

        User user = new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(BCrypt.hashpw(registerUserRequest.getPassword(), BCrypt.gensalt()));
        user.setName(registerUserRequest.getName());

        userRepository.save(user);
    }

    @Override
    public UserResponse get(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }

    @Transactional
    @Override
    public UserResponse update(User user, UpdateUserRequest request) {
        validationService.validate(request);

        // jika object request tidak null, lalu cek didalam object yakni field name tidak null
        if (Objects.nonNull(request.getName())) {
            user.setName(request.getName());
        }

        if (Objects.nonNull(request.getPassword())) {
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }

        userRepository.save(user);

        return UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }
}
