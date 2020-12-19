package pe.org.system.dao;

import java.util.List;
import java.util.Map;
import pe.org.system.model.Rol;

public interface RolDAO {
int create(Rol t);
int update(Rol t);
int delete(int id);
Rol read(int id);
List<Map<String,Object>> readAll();
public Rol findRole(String role);
public Rol obtenerRole(String user);
}
