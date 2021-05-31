package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.Dueno;

public interface IDuenoService {

public boolean insertar(Dueno dueno);
public boolean modificar(Dueno dueno);
public void eliminar(int idDueno);
public Optional<Dueno> buscarId(int idDueno);
public Optional<Dueno> listarId(int idDueno);
public List<Dueno> listar();
}
