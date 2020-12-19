package pe.org.system.service;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Asistencia;

public interface AsistenciaService {
	int create(Asistencia t);
	int update(Asistencia t);
	int delete(int id);
	Asistencia read(int id);
	List<Map<String,Object>> readAll();
	List<Map<String,Object>> readAll(int iduser);
}
