package pe.org.system.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.org.system.dao.DepartamentoDAO;
import pe.org.system.model.Asistencia;
import pe.org.system.model.Departamento;

@Repository
public class DepartamentoDaoImpl implements DepartamentoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Departamento read(int id) {
		String SQL= "SELECT *FROM departamento WHERE iddepartamento=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Departamento>(Departamento.class));
	}

	@Override
	public List<Map<String,Object>> readAll() {
		String SQL= "SELECT *FROM departamento";
		return  jdbcTemplate.queryForList(SQL);
	}

	@Override
	public int getIdDepto(int idd) {
		String SQL = "select dd.iddepartamento, dd.nom_dpto from distrito as d, "
				+ "departamento as dd, provincia as p where d.idprovincia = p.idprovincia and " 
				+ "p.iddepartamento = dd.iddepartamento and d.iddistrito = ?";
		Departamento dpto = jdbcTemplate.queryForObject(SQL, new Object[] {idd}, new BeanPropertyRowMapper<Departamento>(Departamento.class));
		return dpto.getIddepartamento();
	}
	
}
