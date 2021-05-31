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
@Table(name="asesoria")
public class Asesoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CAsesoria;
		
	
	@Column(name="NAsesoria", nullable=false, length=30)
	private String NAsesoria;
	
	@Column(name="TDescripcion", nullable=false, length=50)
	private String TDescripcion;
	
	@Column(name="MPrecio", nullable=false, length=10)
	private int MPrecio;
	
	@ManyToOne
	@JoinColumn(name = "CAsesor", nullable = false)
	private Asesor asesor;

	public int getCAsesoria() {
		return CAsesoria;
	}

	public void setCAsesoria(int cAsesoria) {
		CAsesoria = cAsesoria;
	}

	public String getNAsesoria() {
		return NAsesoria;
	}

	public void setNAsesoria(String nAsesoria) {
		NAsesoria = nAsesoria;
	}

	public String getTDescripcion() {
		return TDescripcion;
	}

	public void setTDescripcion(String tDescripcion) {
		TDescripcion = tDescripcion;
	}

	public int getMPrecio() {
		return MPrecio;
	}

	public void setMPrecio(int mPrecio) {
		MPrecio = mPrecio;
	}

	public Asesor getAsesor() {
		return asesor;
	}

	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}
}
