import org.jvnet.hk2.annotations.Service;
import serviceports.PostService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Service
@Path("endpointb")
public class EndPointB {

    private final PostService postService;

    @Inject
    public EndPointB(PostService postService) {
        this.postService = postService;
    }

    @GET
    public String triggerPostRequest() {
        postService.sendMessage("hello!");
        return "Ok";
    }
}
