package com.mastertech.access.access.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Acesso não encontrado!")
public class AccessNotFoundException extends RuntimeException {
}