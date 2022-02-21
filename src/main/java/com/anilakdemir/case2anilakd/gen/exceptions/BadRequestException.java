package com.anilakdemir.case2anilakd.gen.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author anilakdemir
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
@RequiredArgsConstructor
@Data
public class BadRequestException extends RuntimeException{
    public BadRequestException (String message) {
        super(message);
    }
}
