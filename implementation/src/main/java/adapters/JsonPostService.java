package adapters;

import model.ModelObjectA;
import org.glassfish.jersey.jackson.JacksonFeature;
import serviceports.PostService;

import javax.inject.Inject;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static javax.ws.rs.client.ClientBuilder.newClient;
import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;


public class JsonPostService implements PostService {

    @Inject
    public JsonPostService() {
    }

    /*
            This class uses a rest client to send a post to a remote location.
       */
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending post request!");
        //The message to be sent wrapped as an entityToSend
        ModelObjectA entityToSend = new ModelObjectA(message);
        //The target
        final WebTarget target = newClient().register(JacksonFeature.class).target("http://destinationurl");
        //Preparing the request invocation
        Invocation.Builder requestInvocation = target.request(APPLICATION_JSON_TYPE);
        //Doing a post
        final Response response = requestInvocation.post(entity(entityToSend, APPLICATION_JSON));
        /*
            Note: this is just an example to see how to send a post message.
            The entity is not annotated with Jackson annotations, and thats why it will throw an exception.
        */
    }
}
