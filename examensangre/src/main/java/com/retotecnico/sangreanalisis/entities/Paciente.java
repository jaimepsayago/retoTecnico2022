package com.retotecnico.sangreanalisis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * The persistent class for the rt_paciente database table.
 * 
 */
@Entity
@Table(name="rt_paciente")
@NamedQuery(name="Paciente.findAll", query="SELECT distinct p FROM Paciente p join fetch p.rtExamenSangre")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	
	@Column(name="nombre_paciente")
	private String nombrePaciente;

	//bi-directional many-to-one association to ExamenSangre
	@OneToMany(mappedBy="rtPaciente",fetch= FetchType.EAGER)
	private List<ExamenSangre> rtExamenSangre;
	
	@Column(name = "createdAt")
	private Timestamp createdAt;
    @Column(name = "updatedAt")
	private Timestamp updatedAt;

	public Paciente() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombrePaciente() {
		return this.nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public List<ExamenSangre> getRtExamenSangre() {
		return this.rtExamenSangre;
	}

	public void setRtExamenSangre(List<ExamenSangre> rtExamenSangre) {
		this.rtExamenSangre = rtExamenSangre;
	}
	
	 public Instant getCreatedAt() {
	        return createdAt.toInstant();
	    }

	    public Instant getUpdatedAt() {
	        return updatedAt.toInstant();
	    }

	public ExamenSangre addExamenSangre(ExamenSangre rtExamenSangre) {
		getRtExamenSangre().add(rtExamenSangre);
		rtExamenSangre.setRtPaciente(this);

		return rtExamenSangre;
	}

	public ExamenSangre removeExamenSangre(ExamenSangre rtExamenSangre) {
		getRtExamenSangre().remove(rtExamenSangre);
		rtExamenSangre.setRtPaciente(null);

		return rtExamenSangre;
	}

}