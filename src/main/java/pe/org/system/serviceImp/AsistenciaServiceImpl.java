package pe.org.system.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.org.system.dao.AsistenciaDAO;
import pe.org.system.model.Asistencia;
import pe.org.system.service.AsistenciaService;
@Service
public class AsistenciaServiceImpl implements AsistenciaService {
	@Autowired
	private AsistenciaDAO asistenciaDAO;
		@Override
		public int create(Asistencia t) {
			// TODO Auto-generated method stub
			return asistenciaDAO.create(t);
		}

		@Override
		public int update(Asistencia t) {
			// TODO Auto-generated method stub
			return asistenciaDAO.update(t);
		}

		@Override
		public int delete(int id) {
			// TODO Auto-generated method stub
			return asistenciaDAO.delete(id);
		}

		@Override
		public Asistencia read(int id) {
			// TODO Auto-generated method stub
			return asistenciaDAO.read(id);
		}

		@Override
		public List<Map<String, Object>> readAll() {
			// TODO Auto-generated method stub
			return asistenciaDAO.readAll();
		}

		@Override
		public List<Map<String, Object>> readAll(int iduser) {
			// TODO Auto-generated method stub
			return asistenciaDAO.readAll(iduser);
		}
}
