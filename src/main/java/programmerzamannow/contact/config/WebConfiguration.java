package programmerzamannow.contact.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import programmerzamannow.contact.resolver.UserArgumentResolver;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final UserArgumentResolver userArgumentResolver;

    public WebConfiguration(UserArgumentResolver userArgumentResolver) {
        this.userArgumentResolver = userArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
        resolvers.add(userArgumentResolver);
    }

}
