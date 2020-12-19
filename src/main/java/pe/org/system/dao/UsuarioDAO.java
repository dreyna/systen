package pe.org.system.dao;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Rol;
import pe.org.system.model.Usuario;


public interface UsuarioDAO {
	int create(Usuario t);
	int update(Usuario t);
	int delete(int id);
	Usuario read(int id);
	List<Map<String,Object>> readAll();
	List<Map<String, Object>> login(String correo, String password);
	Usuario findUserByEmail(String correo);
	List<Map<String,Object>> findUserbyRole(Rol role);
}
