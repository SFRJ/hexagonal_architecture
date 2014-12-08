
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import java.net.URI;
import static javax.ws.rs.core.UriBuilder.fromUri;
import static org.glassfish.jersey.jetty.JettyHttpContainerFactory.createServer;

public class EmbeddedServer {

    public void start() {
        URI baseUri = fromUri("http://localhost/").port(9998).build();
        ResourceConfig config = new ResourceConfig();
        config.register(EndpointA.class);
        config.register(EndPointB.class);
        config.register(new ServicesBinder());
        config.register(JacksonFeature.class);
        createServer(baseUri, config);
    }
}
