package programmerzamannow.contact.service.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import programmerzamannow.contact.service.ValidationService;

import java.util.Set;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final Validator validator;

    public ValidationServiceImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void validate(Object request) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);

        if (!constraintViolations.isEmpty()) {
            // error
            throw new ConstraintViolationException(constraintViolations);
        }
    }

}
