package pe.edu.fico.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;




@Entity
@Table(name="asesor")
public class Asesor implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CAsesor;
	
	@NotEmpty(message = "Debe ingresar su nombre*")
	@Column(name="Nnombre", nullable=false, length=30)
	private String Nnombre;
	
	@NotEmpty(message = "Debe ingresar su apellido*")
	@Column(name="Napellido", nullable=false, length=30)
	private String Napellido;
	
	@NotEmpty(message = "Debe ingresar su DNI*")
	@Column(name="Ndni", nullable=false, length=8)
	private int Ndni;
	
	@NotEmpty(message = "Debe ingresar su correo*")
	@Column(name="Tcorreo", nullable=false, length=30)
	private String Tcorreo;
	
	@NotEmpty(message = "Debe ingresar su usuario*")
	@Column(name="Nusuario", nullable=false, length=30)
	private String Nusuario;
	
	@NotEmpty(message = "Debe ingresar su contraseña*")
	@Column(name="Tcontraseña", nullable=false, length=30)
	private String Tcontraseña;
	
	@ManyToOne
	@JoinColumn(name = "CEspecialidad", nullable = false)
	private Especialidad especialidad;
	
	
	public Asesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Asesor(int cAsesor, String nnombre, String napellido, int ndni, String tcorreo, String nusuario,
			String tcontraseña, Especialidad especialidad) {
		super();
		CAsesor = cAsesor;
		Nnombre = nnombre;
		Napellido = napellido;
		Ndni = ndni;
		Tcorreo = tcorreo;
		Nusuario = nusuario;
		Tcontraseña = tcontraseña;
		this.especialidad = especialidad;
	}



	public int getCAsesor() {
		return CAsesor;
	}



	public void setCAsesor(int cAsesor) {
		CAsesor = cAsesor;
	}



	public String getNnombre() {
		return Nnombre;
	}



	public void setNnombre(String nnombre) {
		Nnombre = nnombre;
	}



	public String getNapellido() {
		return Napellido;
	}



	public void setNapellido(String napellido) {
		Napellido = napellido;
	}



	public int getNdni() {
		return Ndni;
	}



	public void setNdni(int ndni) {
		Ndni = ndni;
	}



	public String getTcorreo() {
		return Tcorreo;
	}



	public void setTcorreo(String tcorreo) {
		Tcorreo = tcorreo;
	}



	public String getNusuario() {
		return Nusuario;
	}



	public void setNusuario(String nusuario) {
		Nusuario = nusuario;
	}



	public String getTcontraseña() {
		return Tcontraseña;
	}



	public void setTcontraseña(String tcontraseña) {
		Tcontraseña = tcontraseña;
	}



	public Especialidad getEspecialidad() {
		return especialidad;
	}



	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	
}
