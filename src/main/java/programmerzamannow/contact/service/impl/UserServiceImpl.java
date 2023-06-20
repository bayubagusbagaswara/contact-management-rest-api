package programmerzamannow.contact.service.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import programmerzamannow.contact.dto.RegisterUserRequest;
import programmerzamannow.contact.entity.User;
import programmerzamannow.contact.repository.UserRepository;
import programmerzamannow.contact.security.BCrypt;
import programmerzamannow.contact.service.UserService;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Transactional
    @Override
    public void register(RegisterUserRequest registerUserRequest) {
        Set<ConstraintViolation<RegisterUserRequest>> constraintViolations = validator.validate(registerUserRequest);

        if (constraintViolations.size() != 0) {
            // error
            throw new ConstraintViolationException(constraintViolations);
        }

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
}
