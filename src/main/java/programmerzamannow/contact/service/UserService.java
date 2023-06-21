package programmerzamannow.contact.service;

import programmerzamannow.contact.dto.RegisterUserRequest;
import programmerzamannow.contact.dto.UserResponse;
import programmerzamannow.contact.entity.User;

public interface UserService {

    void register(RegisterUserRequest registerUserRequest);

    UserResponse get(User user);
}
