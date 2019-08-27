package com.teste.campanha.Campanha.socio.torcedor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Ja existe um cadastro para esse e-mail!")
public class EmailException extends Exception{
	private static final long serialVersionUID = 128620846079061103L;
}