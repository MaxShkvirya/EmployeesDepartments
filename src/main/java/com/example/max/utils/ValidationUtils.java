package com.example.max.utils;

import net.sf.oval.ConstraintViolation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationUtils {

    private static final net.sf.oval.Validator VALIDATOR = new net.sf.oval.Validator();

    public static Map<String, String> validate(Object o) {
        Map<String, String> errors = new HashMap<String, String>();
        List<ConstraintViolation> violations = VALIDATOR.validate(o);
        for (ConstraintViolation violation : violations) {
            String field = violation.getContext().toString();
            String key = field.substring(field.lastIndexOf('.') + 1);
            errors.put(key, violation.getMessage());
        }
        return errors;
    }

}
