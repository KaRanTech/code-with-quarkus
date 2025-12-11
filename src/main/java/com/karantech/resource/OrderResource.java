package com.karantech.resource;

import com.karantech.entity.Order;
import com.karantech.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderService service;

    @GET
    public List<Order> list() {
        return service.listAll();
    }

    @POST
    @Path("/customer/{customerId}")
    public Order create(@PathParam("customerId") Long customerId, Order order) {
        return service.create(customerId, order);
    }

    @GET
    @Path("/{id}")
    public Order get(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("/{id}")
    public Order update(@PathParam("id") Long id, Order order) {
        return service.update(id, order);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}

