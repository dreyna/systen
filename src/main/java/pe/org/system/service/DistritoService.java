package pe.org.system.service;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Distrito;

public interface DistritoService {
	Distrito read(int id);
	List<Map<String,Object>> readAll();
}
