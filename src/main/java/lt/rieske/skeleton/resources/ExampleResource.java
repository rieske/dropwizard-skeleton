package lt.rieske.skeleton.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.RequiredArgsConstructor;
import lt.rieske.skeleton.api.Example;

@Path("/api/example")
@RequiredArgsConstructor
public class ExampleResource {

	private final int foo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{bar}")
    public Response example(@PathParam("bar") String bar) {
        return Response.ok(new Example(foo, bar)).build();
    }

}
