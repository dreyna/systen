package pe.org.system.serviceImp;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.org.system.dao.UsuarioDAO;
import pe.org.system.model.Rol;
import pe.org.system.model.Usuario;
import pe.org.system.service.UsuarioService;
@Service
public class UsuarioServiceImpl implements UsuarioService {

		@Autowired
		private UsuarioDAO usuarioDAO;
			@Override
			public int create(Usuario t) {
				// TODO Auto-generated method stub
				return usuarioDAO.create(t);
			}

			@Override
			public int update(Usuario t) {
				// TODO Auto-generated method stub
				return usuarioDAO.update(t);
			}

			@Override
			public int delete(int id) {
				// TODO Auto-generated method stub
				return usuarioDAO.delete(id);
			}

			@Override
			public Usuario read(int id) {
				// TODO Auto-generated method stub
				return usuarioDAO.read(id);
			}

			@Override
			public List<Map<String, Object>> readAll() {
				// TODO Auto-generated method stub
				return usuarioDAO.readAll();
			}

			@Override
			public List<Map<String, Object>> login(String correo, String password) {
				// TODO Auto-generated method stub
				return usuarioDAO.login(correo, password);
			}

			@Override
			public Usuario findUserByEmail(String correo) {
				// TODO Auto-generated method stub
				return usuarioDAO.findUserByEmail(correo);
			}

			@Override
			public List<Map<String, Object>> findUserbyRole(Rol role) {
				// TODO Auto-generated method stub
				return usuarioDAO.findUserbyRole(role);
			}
}
