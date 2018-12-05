package com.opc.projet.gestionbiblio.rest.provider.mapper.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * {@link ExceptionMapper} pour les {@link NotFoundException}
 *
 * @author lgu
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException pException) {
        return Response.status(Response.Status.NOT_FOUND).entity(pException.getMessage()).build();
    }
}