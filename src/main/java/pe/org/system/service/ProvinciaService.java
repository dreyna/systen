package pe.org.system.service;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Provincia;

public interface ProvinciaService {
	Provincia read(int id);
	List<Map<String,Object>> readAll();
}
