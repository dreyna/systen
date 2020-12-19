package pe.org.system.daoImpl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.org.system.dao.ProvinciaDAO;
import pe.org.system.model.Provincia;
@Repository
public class ProvinciaDaoImpl implements ProvinciaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Provincia read(int id) {
		String SQL= "SELECT *FROM provincia WHERE idprovincia=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Provincia>(Provincia.class));
	}

	@Override
	public List<Map<String,Object>> readAll() {
		String SQL= "SELECT *FROM provincia";
		return  jdbcTemplate.queryForList(SQL);
	}
	
}
