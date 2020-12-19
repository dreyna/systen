package pe.org.system.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.org.system.dao.ActividadDAO;
import pe.org.system.model.Actividad;
import pe.org.system.model.Distrito;
import pe.org.system.service.ActividadService;

@Service
public class ActividadServiceImpl implements ActividadService {
@Autowired
private ActividadDAO actividadDAO;
	@Override
	public int create(Actividad t) {
		// TODO Auto-generated method stub
		return actividadDAO.create(t);
	}

	@Override
	public int update(Actividad t) {
		// TODO Auto-generated method stub
		return actividadDAO.update(t);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return actividadDAO.delete(id);
	}

	@Override
	public Actividad read(int id) {
		// TODO Auto-generated method stub
		return actividadDAO.read(id);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return actividadDAO.readAll();
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return actividadDAO.readAll2();
	}

	@Override
	public Distrito readDistrito(int idact) {
		// TODO Auto-generated method stub
		return actividadDAO.readDistrito(idact);
	}

	@Override
	public List<Map<String, Object>> readAll3() {
		// TODO Auto-generated method stub
		return actividadDAO.readAll3();
	}

}
