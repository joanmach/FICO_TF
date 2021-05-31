package pe.edu.fico.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="especialidad")
public class Especialidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CEspecialidad;
	
	
	@Column(name="NEspecialidad", nullable=false, length=30)
	private String NEspecialidad;
	
	@Column(name="TDescripcion", nullable=false, length=30)
	private String TDescripcion;

	
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
