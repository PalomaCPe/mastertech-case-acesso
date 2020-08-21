package com.mastertech.access.access.client.door;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Porta não encontrada")
public class DoorClientNotFoundException extends RuntimeException {
}
