package com.anilakdemir.case2anilakd.gen.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author anilakdemir
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
@Data
public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException (String message) {
        super(message);
    }
}
