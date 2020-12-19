package pe.org.system.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.org.system.dao.RolDAO;
import pe.org.system.model.Rol;
import pe.org.system.service.RolService;
@Service
public class RolServiceImpl implements RolService{
	@Autowired
	private RolDAO rolDAO;
		@Override
		public int create(Rol t) {
			// TODO Auto-generated method stub
			return rolDAO.create(t);
		}

		@Override
		public int update(Rol t) {
			// TODO Auto-generated method stub
			return rolDAO.update(t);
		}

		@Override
		public int delete(int id) {
			// TODO Auto-generated method stub
			return rolDAO.delete(id);
		}

		@Override
		public Rol read(int id) {
			// TODO Auto-generated method stub
			return rolDAO.read(id);
		}

		@Override
		public List<Map<String, Object>> readAll() {
			// TODO Auto-generated method stub
			return rolDAO.readAll();
		}

		@Override
		public Rol findRole(String role) {
			// TODO Auto-generated method stub
			return rolDAO.findRole(role);
		}

		@Override
		public Rol obtenerRole(String user) {
			// TODO Auto-generated method stub
			return rolDAO.obtenerRole(user);
		}
}
