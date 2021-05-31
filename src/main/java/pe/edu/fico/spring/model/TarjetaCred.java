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
@Table(name = "tarjetacredito")

public class TarjetaCred {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CTarjeta;
	
	@Column(name = "NumTarjeta", nullable = false, length = 16)
	private String numTarjeta;
	
	@ManyToOne
	@JoinColumn(name = "CEntidad", nullable = false)
	private EntidadBancaria entidad;

	@ManyToOne
	@JoinColumn(name = "CTTarjeta", nullable = false)
	private TipotarjetaCred ttarjeta;

	@ManyToOne
	@JoinColumn(name = "CDNI", nullable = false)
	private Cliente cliente;
	
	public int getCTarjeta() {
		return CTarjeta;
	}

	public void setCTarjeta(int cTarjeta) {
		CTarjeta = cTarjeta;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public EntidadBancaria getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadBancaria entidad) {
		this.entidad = entidad;
	}

	public TipotarjetaCred getTtarjeta() {
		return ttarjeta;
	}

	public void setTtarjeta(TipotarjetaCred ttarjeta) {
		this.ttarjeta = ttarjeta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
