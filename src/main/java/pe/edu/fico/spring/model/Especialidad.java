package pe.edu.fico.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="especialidad")
public class Especialidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CEspecialidad;
	
	@NotEmpty(message="Debe ingresar el nombre de la especialidad")
	@Column(name="NEspecialidad", nullable=false, length=30)
	private String NEspecialidad;
	
	@NotEmpty(message="Debe ingresar la descripcion de la especialidad")
	@Column(name="TDescripcion", nullable=false, length=50)
	private String TDescripcion;

	

	
	
	
	
	
	public Especialidad() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Especialidad(int cEspecialidad, String nEspecialidad, String tDescripcion) {
		super();
		CEspecialidad = cEspecialidad;
		NEspecialidad = nEspecialidad;
		TDescripcion = tDescripcion;
	}


	public int getCEspecialidad() {
		return CEspecialidad;
	}


	public void setCEspecialidad(int cEspecialidad) {
		CEspecialidad = cEspecialidad;
	}


	public String getNEspecialidad() {
		return NEspecialidad;
	}


	public void setNEspecialidad(String nEspecialidad) {
		NEspecialidad = nEspecialidad;
	}


	public String getTDescripcion() {
		return TDescripcion;
	}


	public void setTDescripcion(String tDescripcion) {
		TDescripcion = tDescripcion;
	}
}
