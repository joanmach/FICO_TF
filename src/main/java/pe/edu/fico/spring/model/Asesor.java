package pe.edu.fico.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="asesor")
public class Asesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CAsesor;
	
	
	@Column(name="Nnombre", nullable=false, length=30)
	private String Nnombre;
	
	@Column(name="Napellido", nullable=false, length=30)
	private String Napellido;
	
	@Column(name="Ndni", nullable=false, length=8)
	private int Ndni;
	
	@Column(name="Tcorreo", nullable=false, length=30)
	private String Tcorreo;
	
	@Column(name="Tcontraseña", nullable=false, length=30)
	private String Tcontraseña;
	
	@ManyToOne
	@JoinColumn(name = "CEspecialidad", nullable = false)
	private Especialidad especialidad;

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
