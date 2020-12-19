package pe.org.system.dao;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Persona;

public interface PersonaDAO {
	int create(Persona t);
	int update(Persona t);
	int delete(int id);
	Persona read(int id);
	int getId(String dni);
	List<Map<String,Object>> readAll();
}
