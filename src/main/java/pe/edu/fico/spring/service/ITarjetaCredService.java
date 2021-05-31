package pe.edu.fico.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.TarjetaCred;

public interface ITarjetaCredService {
	
	public boolean insertar(TarjetaCred tarjeta);
	public boolean modificar(TarjetaCred tarjeta);
	public void eliminar(int CTarjeta);
	public Optional<TarjetaCred> listarId(int CTarjeta);
	List<TarjetaCred> listar();
	List<TarjetaCred> findByNumTarjeta(String NumTarjeta);
}
