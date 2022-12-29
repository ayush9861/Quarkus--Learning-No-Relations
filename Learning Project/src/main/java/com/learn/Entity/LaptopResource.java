package com.learn.Entity;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/lappy")
public class LaptopResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLaptops()
    {

        List<Laptop> laptopList = Laptop.listAll();
        return Response.ok(laptopList).build();

    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addLaptops(Laptop laptop)
    {
        Laptop.persist(laptop);
        if (laptop.isPersistent())
        {

            return Response.created(URI.create("/laptop/" + laptop.id)).build();

        }
        else {

            return Response.noContent().build();
        }
    }
}
