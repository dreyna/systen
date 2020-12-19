package pe.org.system.dao;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Distrito;

public interface DistritoDAO {
	Distrito read(int id);
	List<Map<String,Object>> readAll();
}
