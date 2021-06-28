package pe.edu.fico.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="pais")
public class Pais implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CPais;
	
	@NotNull
	@NotEmpty(message="Debe ingresar el nombre del pais")
	@Column(name="NPais", nullable=false, length=15)
	private String NPais;


	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pais(int cPais, String nPais) {
		super();
		CPais = cPais;
		NPais = nPais;
	}


	public int getCPais() {
		return CPais;
	}


	public void setCPais(int cPais) {
		CPais = cPais;
	}


	public String getNPais() {
		return NPais;
	}


	public void setNPais(String nPais) {
		NPais = nPais;
	}

	
}
