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

package fr.jmottez.parc.position.facade.dto;

/*import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"statusCode", "error", "message"})*/
public class ErrorMessageDTO {

    private int statusCode;

    private String error;

    private String message;

    //@JsonProperty("status_code")
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
