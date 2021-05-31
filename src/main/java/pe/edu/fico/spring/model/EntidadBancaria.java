package pe.edu.fico.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entidadbancaria")
public class EntidadBancaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CEntidad;
		
	
	@Column(name="NEntidad", nullable=false, length=30)
	private String NEntidad;

	public int getCEntidad() {
		return CEntidad;
	}

	public void setCEntidad(int cEntidad) {
		CEntidad = cEntidad;
	}

	public String getNEntidad() {
		return NEntidad;
	}

	public void setNEntidad(String nEntidad) {
		NEntidad = nEntidad;
	}

}
