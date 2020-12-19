package pe.org.system.service;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Departamento;

public interface DepartamentoService {
	Departamento read(int id);
	List<Map<String,Object>> readAll();
	int getIdDepto(int idd);
}
