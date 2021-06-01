package pe.edu.fico.spring.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="horario")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CHorario;
	
	private Date FechaInicio;
	private Date FechaFin;
	
	private Time HoraInicio;
	private Time HoraFin;
	
	
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
	public Time getHoraInicio() {
		return HoraInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		HoraInicio = horaInicio;
	}
	public Time getHoraFin() {
		return HoraFin;
	}
	public void setHoraFin(Time horaFin) {
		HoraFin = horaFin;
	}

	
	
	
}
