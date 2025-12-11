package com.karantech.resource;

import com.karantech.entity.Customer;
import com.karantech.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerService service;

    @GET
    public List<Customer> list() {
        return service.listAll();
    }

    @POST
    public Customer create(Customer c) {
        return service.create(c);
    }

    @GET
    @Path("/{id}")
    public Customer get(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("/{id}")
    public Customer update(@PathParam("id") Long id, Customer c) {
        return service.update(id, c);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}

