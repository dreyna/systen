package pe.org.system.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.org.system.dao.ActividadDAO;
import pe.org.system.model.Actividad;
import pe.org.system.model.Distrito;

@Repository
public class ActividadDaoImpl implements ActividadDAO {
@Autowired
private JdbcTemplate jdbcTemplate;
	@Override
	public int create(Actividad t) {
		String SQL= "INSERT INTO actividad(descripcion, fecha, hora, iddepartamento, estado, mes, iddistrito) VALUES(?,?,?,?,?,MONTHNAME(CURDATE()),?)";
		return jdbcTemplate.update(SQL, t.getDescripcion(), t.getFecha(), t.getHora(),"1",t.getIddepartamento(), t.getIddistrito());
	}

	@Override
	public int update(Actividad t) {
		String SQL= "UPDATE actividad SET descripcion=?, fecha=?, hora=?, iddepartamento=?, iddistrito=? WHERE idactividad=?";
		return jdbcTemplate.update(SQL, t.getDescripcion(), t.getFecha(), t.getHora(), t.getIddepartamento(),t.getIdactividad());
	}

	@Override
	public int delete(int id) {
		String SQL= "DELETE FROM actividad WHERE idctividad =?";
		return jdbcTemplate.update(SQL,id);
	}

	@Override
	public Actividad read(int id) {
		String SQL= "SELECT *FROM actividad WHERE idactividad=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Actividad>(Actividad.class));
	}

	@Override
	public List<Map<String,Object>> readAll() {
		String SQL= "SELECT a.idactividad, a.descripcion, a.fecha, a.hora, d.nom_dpto, dd.nomdistrito, a.estado FROM actividad as a, departamento as d, distrito as dd " 
				+"WHERE a.iddepartamento = d.iddepartamento and a.iddistrito = dd.iddistrito";
		return  jdbcTemplate.queryForList(SQL);	
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		String SQL= "SELECT a.idactividad, a.descripcion, a.fecha, a.hora, d.nom_dpto, a.estado FROM actividad as a, departamento as d " + 
				"WHERE a.iddepartamento = d.iddepartamento and a.estado=1";
		return  jdbcTemplate.queryForList(SQL);
	}

	@Override
	public Distrito readDistrito(int idact) {
		String SQL= "select d.iddistrito, d.nomdistrito, d.idprovincia from actividad as a, distrito as d "
				+ "where a.iddistrito = d.iddistrito and a.idactividad = ?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {idact}, new BeanPropertyRowMapper<Distrito>(Distrito.class));
	}

	@Override
	public List<Map<String, Object>> readAll3() {
		String SQL= "select a.descripcion, d.nom_dpto, a.fecha, a.hora, count(a.idactividad) as cantidad "
				+ "from actividad as a, asistencia as aa, persona as p, departamento as d " 
				+ 	"where a.idactividad = aa.idactividad and aa.idpersona = p.idpersona and "
				+ "a.iddepartamento = d.iddepartamento group by a.idactividad";
		return  jdbcTemplate.queryForList(SQL);
	}
}
