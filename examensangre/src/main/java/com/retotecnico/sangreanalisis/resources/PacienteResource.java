package com.retotecnico.sangreanalisis.resources;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


import com.retotecnico.sangreanalisis.entities.ExamenSangre;
import com.retotecnico.sangreanalisis.entities.Paciente;
import com.retotecnico.sangreanalisis.repositories.ExamenSangrePacienteRepository;
import com.retotecnico.sangreanalisis.repositories.PacienteRepository;



@RequestScoped
@Path("paciente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacienteResource {
	@Inject
    PacienteRepository pacienteRepository;
	@Inject
    ExamenSangrePacienteRepository examenSangrePacienteRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok().entity(pacienteRepository.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getPacienteByIdentificacion(@PathParam("id") Long id) {
        return Response.ok().entity(pacienteRepository.findByIdPaciente(id)).build();
    }
    
    @POST
    public Response create(Paciente paciente, @Context UriInfo uriInfo) {
    	Paciente pacienteId = pacienteRepository.create(paciente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Long.toString(pacienteId.getId()));
        return Response.created(builder.build()).build();
    }
    
    /* Add ExamenSangre to an Paciente */
    
    @POST
    @Path("/{id}/examensangre")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addExamenSangre(@PathParam("id") Long id, ExamenSangre examenSangre, @Context UriInfo uriInfo) {
        ExamenSangre examenSangrePacienteId = examenSangrePacienteRepository.create(examenSangre);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
         builder.path(Long.toString(examenSangrePacienteId.getId()));
        return Response.created(builder.build()).build();
     }
    
    
    /* Get examen de sangre*/
    
    @GET
    @Path("{id}/examensangre")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExamenSangre(@PathParam("id") Long id) {
    	
        Paciente paciente = pacienteRepository.findByIdPaciente(id);
        List<ExamenSangre> esp =paciente.getRtExamenSangre();
        Jsonb jsonb = JsonbBuilder.create();
        String jsonString = jsonb.toJson(esp);
       
        return Response.ok(jsonString).build();
    }
    
    /* Delete examen de sangre*/
    
    @GET
    @Path("{id}/examensangre/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteExamenSangre(@PathParam("id") Long id, @PathParam("id") Long idExamen) {
    	
        Paciente p = pacienteRepository.findByIdPaciente(id);
        if (p == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
                
        }
        
        ExamenSangre examenSangrePaciente = examenSangrePacienteRepository.findById(idExamen);
        if (examenSangrePaciente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        p.removeExamenSangre(examenSangrePaciente);
        pacienteRepository.deleteExamenSangrePaciente(id, idExamen);
        return Response.ok().build();
       
    }

   
}