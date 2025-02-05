package org.skypro.skyshop.controller;

import org.springframework.stereotype.Component;

@Component
public class ShopError {
    private final String code;
    private final String message;

    public ShopError() {
        code = "404";
        message = "Not Found — сервер не нашел ничего, соответствующего запрошенному адресу";
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
