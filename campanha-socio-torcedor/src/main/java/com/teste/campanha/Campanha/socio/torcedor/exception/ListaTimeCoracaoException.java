package com.teste.campanha.Campanha.socio.torcedor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nao ha times de coracoes")
public class ListaTimeCoracaoException extends Exception {
    private static final long serialVersionUID = 5788488741191500322L;
}
