package programmerzamannow.contact.controller;

import org.springframework.web.bind.annotation.RestController;
import programmerzamannow.contact.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
