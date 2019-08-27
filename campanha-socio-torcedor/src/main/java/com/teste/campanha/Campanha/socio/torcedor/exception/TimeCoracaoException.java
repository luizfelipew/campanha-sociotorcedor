package com.teste.campanha.Campanha.socio.torcedor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Time do coracao nao encontrada")
public class TimeCoracaoException extends Exception {
    private static final long serialVersionUID = -8855399950952706600L;
}
