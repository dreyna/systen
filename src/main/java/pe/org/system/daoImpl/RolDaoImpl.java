package pe.org.system.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.org.system.dao.RolDAO;
import pe.org.system.model.Rol;
@Repository
public class RolDaoImpl implements RolDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int create(Rol t) {
		String SQL= "INSERT INTO rol(nomrol) VALUES(?)";
		return jdbcTemplate.update(SQL, t.getNomrol());
	}

	@Override
	public int update(Rol t) {
		String SQL= "UPDATE rol SET nomrol=? WHERE idrol =?";
		return jdbcTemplate.update(SQL, t.getNomrol(), t.getIdrol());
	}

	@Override
	public int delete(int id) {
		String SQL= "DELETE FROM rol WHERE idrol =?";
		return jdbcTemplate.update(SQL,id);
	}

	@Override
	public Rol read(int id) {
		String SQL= "SELECT *FROM rol WHERE idrol=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Rol>(Rol.class));
	}

	@Override
	public List<Map<String,Object>> readAll() {
		String SQL= "SELECT *FROM rol";
		return  jdbcTemplate.queryForList(SQL);	
	}

	@Override
	public Rol findRole(String role) {
		String SQL= "SELECT *FROM rol WHERE nomrol=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {role}, new BeanPropertyRowMapper<Rol>(Rol.class));
	}

	@Override
	public Rol obtenerRole(String user) {
		String SQL= "select r.idrol, r.nomrol from rol as r, usuario as u " + 
				"where r.idrol=u.idrol and u.correo=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {user}, new BeanPropertyRowMapper<Rol>(Rol.class));
	}
	
}
