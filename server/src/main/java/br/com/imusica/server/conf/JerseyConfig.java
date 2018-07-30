package br.com.imusica.server.conf;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.imusica.server.service.ProdutoService;

@Component
@ApplicationPath( "/rest" )
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register( ProdutoService.class );
    }
}