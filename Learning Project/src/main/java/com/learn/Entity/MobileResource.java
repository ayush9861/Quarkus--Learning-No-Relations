package com.learn.Entity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/mobile")
public class MobileResource {
    List<String> mobile = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMobile() {
        return Response.ok(mobile).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response addMobile(String mobileName) {
        mobile.add(mobileName);
        return Response.ok(mobile).build();
    }

    @PUT
    @Path("/{oldmob}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateMobile(@PathParam("oldmob") String oldmob, @QueryParam("newmob") String newmob) {
       mobile =  mobile.stream().map(mobile -> {

            if (mobile.equals(oldmob)) {
                return newmob;
            } else {
                return mobile;

            }
        }).collect(Collectors.toList());
        return Response.ok(mobile).build();
    }

    @DELETE
    @Path("{delete}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("delete") String delete)
    {
        boolean isRemoved = mobile.remove(delete);

        if (isRemoved)
        {

            return Response.noContent().build();
        }
        else
            return Response.ok(mobile).build();
    }

}