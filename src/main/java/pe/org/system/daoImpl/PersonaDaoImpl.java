package pe.org.system.daoImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.org.system.dao.PersonaDAO;
import pe.org.system.model.Persona;
@Repository
public class PersonaDaoImpl implements PersonaDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private CallableStatement stmt = null;
	@Override
	public int create(Persona t) {
		System.out.println("Datos: "+t);
		int x = 0;		
		String SQL ="{call create_persona(?,?,?,?,?,?,?,?,?,?,?,?)}";
		try {
			Connection cx = jdbcTemplate.getDataSource().getConnection();
			stmt = cx.prepareCall(SQL);
			stmt.setString(1, t.getDni());
			stmt.setString(2, t.getNombres());
			stmt.setString(3, t.getApellidos());
			stmt.setInt(4, t.getEdad());
			stmt.setString(5, t.getSexo());
			stmt.setString(6, t.getTelefono());
			stmt.setString(7, t.getCentro_estudios());
			stmt.setString(8, t.getPeriodo());
			stmt.setString(9, t.getCarrera());
			stmt.setInt(10, t.getIddepartamento());
			stmt.setInt(11, t.getIddistrito());
			stmt.registerOutParameter(12, java.sql.Types.INTEGER);
			stmt.executeUpdate();
			x = stmt.getInt(12);
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}		
		return x;
	}

	@Override
	public int update(Persona t) {
		String SQL= "UPDATE persona SET dni=?, nombres=?, edad=?, sexo=?, telefono=?, " + 
				"centro_estudios=?, periodo=?, carrera=?, iddepartamento=? WHERE idpersona=?";
		return jdbcTemplate.update(SQL, t.getDni()
				, t.getNombres()
				, t.getEdad()
				, t.getSexo()
				, t.getTelefono()
				, t.getCentro_estudios()
				, t.getPeriodo()
				, t.getCarrera()
				, t.getIddepartamento()
				, t.getIdpersona());
	}

	@Override
	public int delete(int id) {
		String SQL= "DELETE FROM persona WHERE idpersona =?";
		return jdbcTemplate.update(SQL,id);
	}

	@Override
	public Persona read(int id) {
		String SQL= "SELECT *FROM persona WHERE idpersona=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Persona>(Persona.class));
	}

	@Override
	public List<Map<String,Object>> readAll() {
		String SQL= "SELECT *FROM actividad";
		return  jdbcTemplate.queryForList(SQL);	
	}

	@Override
	public int getId(String dni) {
		String SQL ="select * from persona where dni=?";
		Persona p = jdbcTemplate.queryForObject(SQL, new Object[] {dni}, new BeanPropertyRowMapper<Persona>(Persona.class));
		return p.getIdpersona();
	}
	

}
