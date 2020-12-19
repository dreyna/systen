package pe.org.system.serviceImp;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.org.system.dao.PersonaDAO;
import pe.org.system.model.Persona;
import pe.org.system.service.PersonaSerice;
@Repository
public class PersonaServiceImpl implements PersonaSerice{
	@Autowired
	private PersonaDAO personaDAO;
	@Override
	public int create(Persona t) {
		return personaDAO.create(t);
	}

	@Override
	public int update(Persona t) {
			return personaDAO.update(t);
	}

	@Override
	public int delete(int id) {
		return personaDAO.delete(id);
	}

	@Override
	public Persona read(int id) {
		return personaDAO.read(id);
	}

	@Override
	public List<Map<String,Object>> readAll() {
		return  personaDAO.readAll();	
	}

	@Override
	public int getId(String dni) {
		// TODO Auto-generated method stub
		return personaDAO.getId(dni);
	}
	

}
