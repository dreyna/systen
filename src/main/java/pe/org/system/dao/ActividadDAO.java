package pe.org.system.dao;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Actividad;
import pe.org.system.model.Distrito;

public interface ActividadDAO {
	int create(Actividad t);
	int update(Actividad t);
	int delete(int id);
	Actividad read(int id);
	List<Map<String,Object>> readAll();
	List<Map<String,Object>> readAll2();
	List<Map<String,Object>> readAll3();
	Distrito readDistrito(int idact);
}
