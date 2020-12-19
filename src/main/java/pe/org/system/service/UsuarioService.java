package pe.org.system.service;

import java.util.List;
import java.util.Map;

import pe.org.system.model.Rol;
import pe.org.system.model.Usuario;


public interface UsuarioService {
	int create(Usuario t);
	int update(Usuario t);
	int delete(int id);
	Usuario read(int id);
	List<Map<String,Object>> readAll();
	List<Map<String, Object>> login(String correo, String password);
	public Usuario findUserByEmail(String correo);
	public List<Map<String,Object>> findUserbyRole(Rol role);
}
