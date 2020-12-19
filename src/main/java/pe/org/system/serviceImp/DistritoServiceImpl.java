package pe.org.system.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.org.system.dao.DistritoDAO;
import pe.org.system.model.Distrito;
import pe.org.system.service.DistritoService;
@Service
public class DistritoServiceImpl implements DistritoService {
	@Autowired
	private DistritoDAO distritoDAO;

		@Override
		public Distrito read(int id) {
			// TODO Auto-generated method stub
			return distritoDAO.read(id);
		}

		@Override
		public List<Map<String, Object>> readAll() {
			// TODO Auto-generated method stub
			return distritoDAO.readAll();
		}
	

}
