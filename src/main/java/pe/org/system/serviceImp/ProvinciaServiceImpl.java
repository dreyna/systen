package pe.org.system.serviceImp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.org.system.dao.ProvinciaDAO;
import pe.org.system.model.Provincia;
import pe.org.system.service.ProvinciaService;
@Service
public class ProvinciaServiceImpl implements ProvinciaService {
	@Autowired
	private ProvinciaDAO provinciaDAO;

		@Override
		public Provincia read(int id) {
			// TODO Auto-generated method stub
			return provinciaDAO.read(id);
		}

		@Override
		public List<Map<String, Object>> readAll() {
			// TODO Auto-generated method stub
			return provinciaDAO.readAll();
		}
	
}
