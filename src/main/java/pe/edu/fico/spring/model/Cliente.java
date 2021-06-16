package pe.edu.fico.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CCliente;
	
	@Column(name="NDNI", nullable=false, length=8)
	private int NDNI;
		
	@Column(name="NNombre", nullable=false, length=30)
	private String NNombre;
	
	@Column(name="NApellido", nullable=false, length=30)
	private String NApellido;
	
	@Column(name="TCorreo", nullable=false, length=30)
	private String TCorreo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FNacimiento", nullable=false, length=50)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date FNacimiento;
	
	@Column(name="NUsuaruio", nullable=false, length=30)
	private String NUsuario;
	
	@Column(name="TContraseña", nullable=false, length=30)
	private String TContraseña;
	
	@ManyToOne
	@JoinColumn(name = "CCiudad", nullable = false)
	private Ciudad ciudad;

	private Boolean enabled;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="usear_id")
	private List<Role> roles;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int cCliente, int nDNI, String nNombre, String nApellido, String tCorreo, Date fNacimiento,
			String nUsuario, String tContraseña, Ciudad ciudad) {
		super();
		CCliente = cCliente;
		NDNI = nDNI;
		NNombre = nNombre;
		NApellido = nApellido;
		TCorreo = tCorreo;
		FNacimiento = fNacimiento;
		NUsuario = nUsuario;
		TContraseña = tContraseña;
		this.ciudad = ciudad;
	}

	public int getCCliente() {
		return CCliente;
	}

	public int getNDNI() {
		return NDNI;
	}

	public void setNDNI(int nDNI) {
		NDNI = nDNI;
	}

	public String getNNombre() {
		return NNombre;
	}

	public void setNNombre(String nNombre) {
		NNombre = nNombre;
	}

	public String getNApellido() {
		return NApellido;
	}

	public void setNApellido(String nApellido) {
		NApellido = nApellido;
	}

	public String getTCorreo() {
		return TCorreo;
	}

	public void setTCorreo(String tCorreo) {
		TCorreo = tCorreo;
	}

	public Date getFNacimiento() {
		return FNacimiento;
	}

	public void setFNacimiento(Date fNacimiento) {
		FNacimiento = fNacimiento;
	}

	public String getNUsuario() {
		return NUsuario;
	}

	public void setNUsuario(String nUsuario) {
		NUsuario = nUsuario;
	}

	public String getTContraseña() {
		return TContraseña;
	}

	public void setTContraseña(String tContraseña) {
		TContraseña = tContraseña;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public void setCCliente(int cCliente) {
		CCliente = cCliente;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
}
