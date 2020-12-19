package pe.org.system.dao;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Provincia;

public interface ProvinciaDAO {
	Provincia read(int id);
	List<Map<String,Object>> readAll();
}
