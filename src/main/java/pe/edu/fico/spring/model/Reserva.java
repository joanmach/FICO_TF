package pe.edu.fico.spring.model;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")

public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CReserva;
	
	
	@ManyToOne
	@JoinColumn(name = "CAsesoria", nullable = false)
	private Asesoria asesoria;

	@ManyToOne
	@JoinColumn(name = "CCliente", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "CHorario", nullable = false)
	private Horario horario;

	
	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reserva(int cReserva, Asesoria asesoria, Cliente cliente, Horario horario) {
		super();
		CReserva = cReserva;
		this.asesoria = asesoria;
		this.cliente = cliente;
		this.horario = horario;
	}


	public int getCReserva() {
		return CReserva;
	}

	public void setCReserva(int cReserva) {
		CReserva = cReserva;
	}

	public Asesoria getAsesoria() {
		return asesoria;
	}

	public void setAsesoria(Asesoria asesoria) {
		this.asesoria = asesoria;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
	
}
