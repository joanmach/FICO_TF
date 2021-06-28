package pe.edu.fico.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tarjetacredito")

public class TarjetaCred {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CTarjeta;
	
	@NotEmpty(message="Debe ingresar el numero de la tarjeta")
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
	
	
	
	
	
	
	public TarjetaCred() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TarjetaCred(int cTarjeta, String numTarjeta, EntidadBancaria entidad, TipotarjetaCred ttarjeta,
			Cliente cliente) {
		super();
		CTarjeta = cTarjeta;
		this.numTarjeta = numTarjeta;
		this.entidad = entidad;
		this.ttarjeta = ttarjeta;
		this.cliente = cliente;
	}

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
