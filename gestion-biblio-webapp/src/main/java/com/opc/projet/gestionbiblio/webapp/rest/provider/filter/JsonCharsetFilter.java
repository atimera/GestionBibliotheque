package com.opc.projet.gestionbiblio.webapp.rest.provider.filter;

import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JsonCharsetFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext pRequestContext,
                       ContainerResponseContext pResponseContext) throws IOException {
        pResponseContext.getHeaders().putSingle("Content-type",
                MediaType.APPLICATION_JSON + ';' + MediaType.CHARSET_PARAMETER
                        + "=utf-8");
    }
}