package programmerzamannow.contact.controller;

import org.springframework.web.bind.annotation.RestController;
import programmerzamannow.contact.service.AuthService;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
}
