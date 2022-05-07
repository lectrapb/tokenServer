package com.auth.authserver.domain.model.util;

import lombok.Data;

@Data
public class ApiResponseError {

    private Boolean ok;
    private String message;
}
