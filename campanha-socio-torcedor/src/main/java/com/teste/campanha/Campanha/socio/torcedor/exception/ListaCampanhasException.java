package com.teste.campanha.Campanha.socio.torcedor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nao ha campanhas")
public class ListaCampanhasException extends Exception {
    private static final long serialVersionUID = 635510511732661380L;
}
