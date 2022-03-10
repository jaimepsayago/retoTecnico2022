package com.retotecnico.sangreanalisis.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.retotecnico.sangreanalisis.entities.ExamenSangre;
import com.retotecnico.sangreanalisis.entities.Paciente;


import java.util.List;

/**
 * Interface para definir las operaciones de bdd relacionadas con el examen de sangre
 * @author JSH
 *
 */

@Stateless
public class PacienteRepository {
	  @PersistenceContext(unitName = "persistence")
	    EntityManager em;
	  
		/**
		 * Definición de método para buscar todos los pacientes
		 */

	    public List<Paciente> getAll() {
	        return em.createNamedQuery("Paciente.findAll", Paciente.class).getResultList();
	    }
		/**
		 * Definición de método para buscar un paciente por su identificación
		 * @param identificacionPaciente
		 * @return
		 */
	    public Paciente findByIdPaciente(Long id) {
	        return em.find(Paciente.class, id);
	    }
	    
	    public Paciente findByIdentificacion(String identificacionPaciente) {
	    	return (Paciente) em.createNamedQuery("Paciente.findByIdentificacion", Paciente.class )
	    			.setParameter("identificacionPaciente", identificacionPaciente)
	    			.getResultList();
	    	//return em.find(Paciente.class,identificacionPaciente);
	    }
	    /**
		 * Definición de método para crear un paciente
		 */
	    public Paciente create(Paciente paciente) {
	        em.persist(paciente);
	        return paciente;
	    }
	    public Long createComment(Long id, ExamenSangre esp) {
	        try {
	            findByIdPaciente(id).addExamenSangre(esp);
	            em.persist(esp);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return esp.getId();
	    }

	    public ExamenSangre findExamenSangrePaciente(Long idExamen) {
	        try {
	            return em.find(ExamenSangre.class, idExamen);
	        } catch (NoResultException e) {
	            return null;
	        }
	    }

	    public void deleteExamenSangrePaciente(Long id, Long idExamen) {
	        em.remove(findExamenSangrePaciente(idExamen));
	    }
}

