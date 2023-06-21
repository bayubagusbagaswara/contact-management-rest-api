package programmerzamannow.contact.resolver;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.server.ResponseStatusException;
import programmerzamannow.contact.entity.User;
import programmerzamannow.contact.repository.UserRepository;

@Slf4j
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    
    private final UserRepository userRepository;

    public UserArgumentResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // jika equal, maka baru berjalan
        return User.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(@NonNull MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = (HttpServletRequest) webRequest.getNativeRequest();
        String token = servletRequest.getHeader("X-API-TOKEN");

        if (token == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }

        // cek ke database
        User user = userRepository.findFirstByToken(token)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized"));

        log.info("USER {}", user);

        // cek token expired apakah lewat dengan waktu sekarang
        if (user.getTokenExpiredAt() < System.currentTimeMillis()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }

        return user;
    }
}
