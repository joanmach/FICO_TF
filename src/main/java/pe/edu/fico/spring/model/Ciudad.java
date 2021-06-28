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

@Entity
@Table(name="ciudad")
public class Ciudad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CCiudad;
	
	
	@Column(name="NPais", nullable=false, length=15)
	private String NCiudad;
	
	@ManyToOne
	@JoinColumn(name="CPais", nullable=false)
	private Pais pais;

	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ciudad(int cCiudad, String nCiudad, Pais pais) {
		super();
		CCiudad = cCiudad;
		NCiudad = nCiudad;
		this.pais = pais;
	}

	public int getCCiudad() {
		return CCiudad;
	}

	public void setCCiudad(int cCiudad) {
		CCiudad = cCiudad;
	}

	public String getNCiudad() {
		return NCiudad;
	}

	public void setNCiudad(String nCiudad) {
		NCiudad = nCiudad;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
