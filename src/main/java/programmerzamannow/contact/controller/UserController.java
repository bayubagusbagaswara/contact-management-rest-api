package programmerzamannow.contact.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import programmerzamannow.contact.dto.RegisterUserRequest;
import programmerzamannow.contact.dto.WebResponse;
import programmerzamannow.contact.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RegisterUserRequest registerUserRequest) {
        userService.register(registerUserRequest);
        return WebResponse.<String>builder().data("OK").build();
    }

}
