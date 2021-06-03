package pe.edu.fico.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="meta")
public class Meta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CMeta;
	
	
	@Column(name="NMeta", nullable=false, length=30)
	private String NMeta;
	
	@Column(name="TDescripcion", nullable=false, length=50)
	private String TDescripcion;
	
	private Date FechaInicio;
	
	private Date FechaFin;

	public int getCMeta() {
		return CMeta;
	}

	public void setCMeta(int cMeta) {
		CMeta = cMeta;
	}

	public String getNMeta() {
		return NMeta;
	}

	public void setNMeta(String nMeta) {
		NMeta = nMeta;
	}

	public String getTDescripcion() {
		return TDescripcion;
	}

	public void setTDescripcion(String tDescripcion) {
		TDescripcion = tDescripcion;
	}

	public Date getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
	}


	
	
}
