package com.learn.Entity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/mobileobj")
public class MobileResourceObject {
    List<Mobile> moblileList = new ArrayList<>();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMobiles() {

        return Response.ok(moblileList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMobiles(Mobile mobile) {
        moblileList.add(mobile);
        return Response.ok(moblileList).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMobile(@PathParam("id") int id, Mobile mobileToUpdate) {
        moblileList = moblileList.stream().map(mobile -> {
                    if (mobileToUpdate.getId() == id) {

                        return mobileToUpdate;
                    } else {

                        return mobile;
                    }
                }
        ).collect(Collectors.toList());

        return Response.ok(moblileList).build();

    }

    @DELETE
    @Path("/{id}")
    public Response mobileDelete(@PathParam("id") int mobileToDelete) {
        Optional<Mobile> mobiletoDelete = moblileList.stream().filter(mobile -> mobile.getId() == mobileToDelete).findFirst();
        if (mobiletoDelete.isPresent()) {
            moblileList.remove(mobiletoDelete);
            return Response.ok(moblileList).build();
        } else {

            return Response.noContent().build();
        }
    }
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int getDataById)
    {
        Optional<Mobile> getById= moblileList.stream().filter(mobile -> mobile.getId() == getDataById).findFirst();
        if (getById.isPresent())
        {
            return Response.ok(getById.get()).build();
        }
        else
        {

            return  Response.noContent().build();
        }

    }

}
