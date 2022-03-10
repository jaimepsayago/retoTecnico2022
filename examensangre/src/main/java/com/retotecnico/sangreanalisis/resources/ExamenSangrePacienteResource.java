package com.retotecnico.sangreanalisis.resources;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.retotecnico.sangreanalisis.entities.ExamenSangre;

import com.retotecnico.sangreanalisis.repositories.ExamenSangrePacienteRepository;


@RequestScoped
@Path("examenSangrePaciente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamenSangrePacienteResource {
	@Inject
    ExamenSangrePacienteRepository examenSangrePacienteRepository;

	
    @GET
    public Response getAll() {
        return Response.ok().entity(examenSangrePacienteRepository.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getPostById(@PathParam("id") Long id) {
        return Response.ok().entity(examenSangrePacienteRepository.findById(id)).build();
    }

    @POST
    public Response create(ExamenSangre examenSangre, @Context UriInfo uriInfo) {
 	
    	ExamenSangre examenSangrePacienteId = examenSangrePacienteRepository.create(examenSangre);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
         builder.path(Long.toString(examenSangrePacienteId.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, ExamenSangre examenSangre) {
    	ExamenSangre updateExamenSangrePaciente = examenSangrePacienteRepository.findById(id);
    	updateExamenSangrePaciente.setPorcentajeAzucar(examenSangre. getPorcentajeAzucar());
    	updateExamenSangrePaciente.setPorcentajeAzucar(examenSangre.getPorcentajeGrasa());
    	updateExamenSangrePaciente.setPorcentajeAzucar(examenSangre.getPorcentajeOxigeno());
    	updateExamenSangrePaciente.setDescripcion(examenSangre.getDescripcion());

        return Response.ok().entity(examenSangre).build();
    }

   
    
    
    
}