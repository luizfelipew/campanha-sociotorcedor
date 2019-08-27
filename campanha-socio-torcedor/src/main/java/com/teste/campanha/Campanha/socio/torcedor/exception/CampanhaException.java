package com.teste.campanha.Campanha.socio.torcedor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Campanha nao encontrada")
public class CampanhaException extends Exception {
    private static final long serialVersionUID = -2089991223392975971L;
}
