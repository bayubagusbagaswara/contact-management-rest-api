package programmerzamannow.contact.service.impl;

import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import programmerzamannow.contact.service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final Validator validator;

    public ValidationServiceImpl(Validator validator) {
        this.validator = validator;
    }
}
