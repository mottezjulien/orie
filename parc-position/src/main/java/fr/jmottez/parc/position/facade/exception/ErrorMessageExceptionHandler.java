/*
 * Copyright (c) 2008-2017 Linxo, All Rights Reserved.
 *
 *    COPYRIGHT:
 *         This software is the property of Linxo.
 *         It cannot be copied, used, or modified without obtaining an
 *         authorization from the authors or a person mandated by Linxo.
 *         If such an authorization is provided, any modified version
 *         or copy of the software has to contain this header.
 *
 *    WARRANTIES:
 *         This software is made available by the authors in the hope
 *         that it will be useful, but without any warranty.
 *         Linxo is not liable for any consequence related to
 *         the use of the provided software.
 */

package fr.jmottez.parc.position.facade.exception;

import fr.jmottez.parc.position.facade.dto.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorMessageExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception exception, WebRequest request) {
        ErrorMessageDTO message = new ErrorMessageDTO();
        message.setError("Internal error occured");
        message.setMessage(exception.getLocalizedMessage());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler({NotFoundFacadeException.class })
    public ResponseEntity<Object> handleApiException(NotFoundFacadeException exception, WebRequest request) {
        ErrorMessageDTO message = new ErrorMessageDTO();
        message.setError("Object not found");
        message.setMessage(exception.getLocalizedMessage());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
