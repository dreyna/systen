package pe.org.system.dao;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Departamento;

public interface DepartamentoDAO {
	Departamento read(int id);
	List<Map<String,Object>> readAll();
	int getIdDepto(int idd);
}
