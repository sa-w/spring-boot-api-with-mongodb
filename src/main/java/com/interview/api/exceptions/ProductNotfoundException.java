package com.interview.api.exceptions;

import org.springframework.stereotype.Component;

@Component
public class ProductNotfoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
