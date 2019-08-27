package com.teste.campanha.Campanha.socio.torcedor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Socio Torcedor nao encontrada")
public class SocioTorcedorException extends Exception {
    private static final long serialVersionUID = 8374123637643355623L;
}
