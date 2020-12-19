package pe.org.system.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.org.system.dao.AsistenciaDAO;
import pe.org.system.model.Asistencia;
@Repository
public class AsistenciaDaoImp implements AsistenciaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int create(Asistencia t) {
		String SQL= "INSERT INTO asistencia(fecha, hora, idactividad, idusuario, iddistrito, idpersona) "
				+ "VALUES(curdate(),now(),?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getIdactividad(), t.getIdusuario(), t.getIddistrito(), t.getIdpersona());
	}

	@Override
	public int update(Asistencia t) {
		String SQL= "UPDATE asistencia SET idactividad=?, iddistrito=? WHERE idasistencia=";
		return jdbcTemplate.update(SQL, t.getIdactividad(), t.getIddistrito(), t.getIdasistencia());
	}

	@Override
	public int delete(int id) {
		String SQL= "DELETE FROM asistencia WHERE idasistencia =?";
		return jdbcTemplate.update(SQL,id);
	}

	@Override
	public Asistencia read(int id) {
		String SQL= "SELECT *FROM asistencia WHERE idasistencia=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Asistencia>(Asistencia.class));
	}

	@Override
	public List<Map<String,Object>> readAll() {
		String SQL= "select ac.descripcion, p.nombres, p.apellidos, a.fecha, a.hora, d.nomdistrito, u.correo from asistencia as a, "
				+ "actividad as ac, distrito as d, persona as p, usuario as u where " 
				+ 	"a.idactividad = ac.idactividad and a.iddistrito = d.iddistrito and a.idpersona = p.idpersona and "
				+ "a.idusuario = u.idusuario";
		return  jdbcTemplate.queryForList(SQL);
	}

	@Override
	public List<Map<String, Object>> readAll(int iduser) {
		String SQL = "SELECT d.nom_dpto, p.nomprovincia, dd.nomdistrito, aa.descripcion, aa.fecha, a.hora FROM asistencia as a, "
				+ "actividad as aa, departamento as d, provincia as p, distrito as dd, usuario as u " 
				+ 	"where a.idactividad=aa.idactividad and a.idusuario=u.idusuario and dd.iddistrito = a.iddistrito and " 
				+ 	"dd.idprovincia=p.idprovincia and p.iddepartamento = d.iddepartamento and u.idusuario=?";
		return jdbcTemplate.queryForList(SQL, new Object[] {iduser});
	}
}
