package com.retotecnico.sangreanalisis.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the rt_paciente database table.
 * 
 */
@Entity
@Table(name="rt_paciente")
@NamedQuery(name="Paciente.findAll", query="SELECT p.id, p.nombre FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="apellido_paciente")
	private String apellidoPaciente;

	@Temporal(TemporalType.DATE)
	@Column(name="\"created_Paciente\"")
	private Date created_Paciente;

	private Timestamp created;

	@Column(name="direccion_paciente")
	private String direccionPaciente;

	@Column(name="email_paciente")
	private String emailPaciente;

	@Column(name="identificacion_paciente")
	private String identificacionPaciente;

	@Column(name="nombre_paciente")
	private String nombrePaciente;

	@Column(name="telefono_paciente")
	private String telefonoPaciente;

	@Temporal(TemporalType.DATE)
	@Column(name="\"updated_Pacient\"")
	private Date updated_Pacient;

	@Column(name="updated_paciente")
	private Timestamp updatedPaciente;

	private Timestamp update;

	//bi-directional many-to-one association to ExamenSangre
	@OneToMany(mappedBy="rtPaciente", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<ExamenSangre> rtExamenSangre;

	public Paciente() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellidoPaciente() {
		return this.apellidoPaciente;
	}

	public void setApellidoPaciente(String apellidoPaciente) {
		this.apellidoPaciente = apellidoPaciente;
	}

	public Date getCreated_Paciente() {
		return this.created_Paciente;
	}

	public void setCreated_Paciente(Date created_Paciente) {
		this.created_Paciente = created_Paciente;
	}

	
	public String getDireccionPaciente() {
		return this.direccionPaciente;
	}

	public void setDireccionPaciente(String direccionPaciente) {
		this.direccionPaciente = direccionPaciente;
	}

	public String getEmailPaciente() {
		return this.emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	public String getIdentificacionPaciente() {
		return this.identificacionPaciente;
	}

	public void setIdentificacionPaciente(String identificacionPaciente) {
		this.identificacionPaciente = identificacionPaciente;
	}

	public String getNombrePaciente() {
		return this.nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getTelefonoPaciente() {
		return this.telefonoPaciente;
	}

	public void setTelefonoPaciente(String telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}

	public Date getUpdated_Pacient() {
		return this.updated_Pacient;
	}

	public void setUpdated_Pacient(Date updated_Pacient) {
		this.updated_Pacient = updated_Pacient;
	}

	public Timestamp getUpdatedPaciente() {
		return this.updatedPaciente;
	}

	public void setUpdatedPaciente(Timestamp updatedPaciente) {
		this.updatedPaciente = updatedPaciente;
	}

	

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdate() {
		return update;
	}

	public void setUpdate(Timestamp update) {
		this.update = update;
	}

	public List<ExamenSangre> getRtExamenSangre() {
		return this.rtExamenSangre;
	}

	public void setRtExamenSangre(List<ExamenSangre> rtExamenSangre) {
		this.rtExamenSangre = rtExamenSangre;
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