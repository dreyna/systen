package pe.org.system.service;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Persona;

public interface PersonaSerice {
	int create(Persona t);
	int update(Persona t);
	int delete(int id);
	Persona read(int id);
	List<Map<String,Object>> readAll();
	int getId(String dni);
}
