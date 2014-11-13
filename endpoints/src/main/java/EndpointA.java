import org.jvnet.hk2.annotations.Service;
import serviceports.ServicePortAlpha;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Service
@Path("endpointa")
public class EndpointA {

    private final ServicePortAlpha portAlpha;

    @Inject
    public EndpointA(ServicePortAlpha portAlpha) {
        this.portAlpha = portAlpha;
    }

    /*
    This endpoint will be triggered by json messages like this one(Jackson will
    unmarshall automatically):
    {
        "param1": "blabla",
        "param2": "bleble"
    }
    */

    @POST
    @Consumes({"application/json"})
    public String post(SomeRequest someRequest) throws Exception {
        //To avoid adding unnecesary annotations into the core model I use specific models in the
        //endpoints that I map to the core entities if I need to.
        final String request = someRequest.getParam1();
        portAlpha.doSomething(request);
        return "ok";
    }
}
