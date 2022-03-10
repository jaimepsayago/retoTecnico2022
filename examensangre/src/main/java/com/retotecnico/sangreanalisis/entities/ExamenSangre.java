package com.retotecnico.sangreanalisis.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.*;


/**
 * The persistent class for the rt_examen_sangre database table.
 * 
 */
@Entity
@Table(name="rt_examen_sangre")
@NamedQuery(name="ExamenSangre.findAll", query="SELECT e FROM ExamenSangre e")
public class ExamenSangre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String descripcion;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="id_paciente")
	private Paciente rtPaciente;

	private double porcentajeAzucar;


	private double porcentajeGrasa;

	private double porcentajeOxigeno;
	
	@Column(name = "createdAt")
	private Timestamp createdAt;
    @Column(name = "updatedAt")
	private Timestamp updatedAt;
	
	public ExamenSangre() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Paciente getRtPaciente() {
		return this.rtPaciente;
	}

	public void setRtPaciente(Paciente rtPaciente) {
		this.rtPaciente = rtPaciente;
	}

	public double getPorcentajeAzucar() {
		return porcentajeAzucar;
	}

	public void setPorcentajeAzucar(double porcentajeAzucar) {
		this.porcentajeAzucar = porcentajeAzucar;
	}

	public double getPorcentajeGrasa() {
		return porcentajeGrasa;
	}

	public void setPorcentajeGrasa(double porcentajeGrasa) {
		this.porcentajeGrasa = porcentajeGrasa;
	}

	public double getPorcentajeOxigeno() {
		return porcentajeOxigeno;
	}

	public void setPorcentajeOxigeno(double porcentajeOxigeno) {
		this.porcentajeOxigeno = porcentajeOxigeno;
	}
	
	 public Instant getCreatedAt() {
	        return createdAt.toInstant();
	    }

	    public Instant getUpdatedAt() {
	        return updatedAt.toInstant();
	    }

}