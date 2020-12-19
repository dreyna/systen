package pe.org.system.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.org.system.dao.DepartamentoDAO;
import pe.org.system.model.Departamento;
import pe.org.system.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	@Autowired
	private DepartamentoDAO departamentoDAO;

		@Override
		public Departamento read(int id) {
			// TODO Auto-generated method stub
			return departamentoDAO.read(id);
		}

		@Override
		public List<Map<String, Object>> readAll() {
			// TODO Auto-generated method stub
			return departamentoDAO.readAll();
		}

		@Override
		public int getIdDepto(int idd) {
			// TODO Auto-generated method stub
			return departamentoDAO.getIdDepto(idd);
		}
	
}
