package pe.org.system.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.org.system.dao.DistritoDAO;
import pe.org.system.model.Distrito;
@Repository
public class DistritoDaoImpl implements DistritoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Distrito read(int id) {
		String SQL= "SELECT *FROM distrito WHERE iddistrito=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Distrito>(Distrito.class));
	}

	@Override
	public List<Map<String,Object>> readAll() {
		String SQL= "SELECT *FROM distrito";
		return  jdbcTemplate.queryForList(SQL);
	}
	

}
