package com.retotecnico.sangreanalisis.entities;

import java.io.Serializable;
import java.sql.Timestamp;


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

	@Column(name = "porcentaje_azucar")
	private double porcentajeAzucar;
	@Column(name = "porcentaje_grasa")
	private double porcentajeGrasa;
	@Column(name = " porcentaje_oxigeno")
	private double porcentajeOxigeno;
	
	@Column(name = "created")
	private Timestamp created;
    @Column(name = "updated")
	private Timestamp updated;
	
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

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	
	

}