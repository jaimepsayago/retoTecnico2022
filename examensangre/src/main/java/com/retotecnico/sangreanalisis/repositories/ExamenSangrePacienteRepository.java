package com.retotecnico.sangreanalisis.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.retotecnico.sangreanalisis.entities.ExamenSangre;


import java.util.List;

/**
 * Interface para definir las operaciones de bdd relacionadas con los examenes de sangre
 * @author JSH
 *
 */
@Stateless
public class ExamenSangrePacienteRepository {
	  @PersistenceContext(unitName = "persistence")
	    EntityManager em;
	  
		/**
		 * Definición de método para buscar todos los examenes de sangre
		 */
	    public List<ExamenSangre> getAll() {
	        return em.createNamedQuery("ExamenSangre.findAll", ExamenSangre.class).getResultList();
	    }
		/**
		 * Definición de método para buscar un examen de sangre por su identificación
		 * @param idExamenSangre
		 * @return
		 */
	    public ExamenSangre findById(Long id) {
	        return em.find(ExamenSangre.class, id);
	    }
		/**
		 * Definición de método para crear un examen de sangre del paciente
		 */
	    public ExamenSangre create(ExamenSangre examenSangre) {
	    
	        em.persist(examenSangre);
	        return examenSangre;
	    }
		/**
		 * Definición de método para actualizar un examen de sangre del paciente
		 * @param ExamenSangrePaciente
		 * @return
		 */
	    public void update(ExamenSangre examenSangre) {
	        em.merge(examenSangre);
	    }
		/**
		 * Definición de método para remover un examen de sangre por su identificación
		 * @param ExamenSangrePaciente
		 * @return
		 */
	    public void delete(ExamenSangre examenSangre) {
	        if (!em.contains(examenSangre)) {
	        	examenSangre = em.merge(examenSangre);
	        }

	        em.remove(examenSangre);
	    }
	}
