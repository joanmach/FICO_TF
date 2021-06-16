package pe.edu.fico.spring.model;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="horario")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CHorario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FechaInicio",nullable=false, length = 50)
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date FechaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FechaFin",nullable=false, length = 50)
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date FechaFin;
	
	@Column(name="HoraInicio",nullable=false, length = 50)
	@Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern= "HH:mm")
	private Date HoraInicio;
		
	@Column(name="HoraFin",nullable=false, length = 50)
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern= "HH:mm")
	private Date HoraFin;

	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Horario(int cHorario, Date fechaInicio, Date fechaFin , Date horaInicio, Date horaFin) {
		super();
		CHorario = cHorario;
		FechaInicio = fechaInicio;
		FechaFin = fechaFin;
		HoraInicio = horaInicio;
		HoraFin = horaFin;
	}
	public int getCHorario() {
		return CHorario;
	}

	public void setCHorario(int cHorario) {
		CHorario = cHorario;
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

	public Date getHoraInicio() {
		return HoraInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		HoraInicio = horaInicio;
	}

	public Date getHoraFin() {
		return HoraFin;
	}

	public void setHoraFin(Date horaFin) {
		HoraFin = horaFin;
	}
	
	
	
	
	
	
}
