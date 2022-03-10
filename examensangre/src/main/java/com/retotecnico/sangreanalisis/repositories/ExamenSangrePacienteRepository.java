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
		 * Definici�n de m�todo para buscar todos los examenes de sangre
		 */
	    public List<ExamenSangre> getAll() {
	        return em.createNamedQuery("ExamenSangre.findAll", ExamenSangre.class).getResultList();
	    }
		/**
		 * Definici�n de m�todo para buscar un examen de sangre por su identificaci�n
		 * @param idExamenSangre
		 * @return
		 */
	    public ExamenSangre findById(Long id) {
	        return em.find(ExamenSangre.class, id);
	    }
		/**
		 * Definici�n de m�todo para crear un examen de sangre del paciente
		 */
	    public ExamenSangre create(ExamenSangre examenSangre) {
	    
	        em.persist(examenSangre);
	        return examenSangre;
	    }
		/**
		 * Definici�n de m�todo para actualizar un examen de sangre del paciente
		 * @param ExamenSangrePaciente
		 * @return
		 */
	    public void update(ExamenSangre examenSangre) {
	        em.merge(examenSangre);
	    }
		/**
		 * Definici�n de m�todo para remover un examen de sangre por su identificaci�n
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
