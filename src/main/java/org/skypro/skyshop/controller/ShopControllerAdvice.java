package org.skypro.skyshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    private ShopError shopError;

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> noSuchProductHandler(NoSuchProductException e) {
        return ResponseEntity.notFound().header(shopError.getCode(), shopError.getMessage(), e.getMessage()).build();
    }

}
