package programmerzamannow.contact.service;

import programmerzamannow.contact.dto.LoginUserRequest;
import programmerzamannow.contact.dto.TokenResponse;

public interface AuthService {

    TokenResponse login(LoginUserRequest request);
}
