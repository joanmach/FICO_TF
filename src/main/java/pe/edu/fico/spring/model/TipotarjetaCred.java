package pe.edu.fico.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="tipotarjetacredito")
public class TipotarjetaCred {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CTTarjeta;
	
	@NotEmpty(message="Debe ingresar el nombre del tipo de tarjeta")
	@Column(name="NTTarjeta", nullable=false, length=30)
	private String NTTarjeta;


	
	
	public TipotarjetaCred() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TipotarjetaCred(int cTTarjeta, String nTTarjeta) {
		super();
		CTTarjeta = cTTarjeta;
		NTTarjeta = nTTarjeta;
	}


	public int getCTTarjeta() {
		return CTTarjeta;
	}


	public void setCTTarjeta(int cTTarjeta) {
		CTTarjeta = cTTarjeta;
	}


	public String getNTTarjeta() {
		return NTTarjeta;
	}


	public void setNTTarjeta(String nTTarjeta) {
		NTTarjeta = nTTarjeta;
	}
	
	
	
}
