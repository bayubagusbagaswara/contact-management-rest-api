package programmerzamannow.contact.service;

import programmerzamannow.contact.dto.LoginUserRequest;
import programmerzamannow.contact.dto.TokenResponse;
import programmerzamannow.contact.entity.User;

public interface AuthService {

    TokenResponse login(LoginUserRequest request);

    void logout(User user);
}
