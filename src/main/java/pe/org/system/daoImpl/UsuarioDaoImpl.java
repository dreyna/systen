package pe.org.system.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import pe.org.system.dao.UsuarioDAO;
import pe.org.system.model.Rol;
import pe.org.system.model.Usuario;
@Repository
public class UsuarioDaoImpl implements UsuarioDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public int create(Usuario t) {
		t.setPassword(bCryptPasswordEncoder.encode(t.getPassword()));
		String SQL= "INSERT INTO usuario(correo, password, active, idpersona, idrol) VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(SQL, 
				t.getCorreo(),
				t.getPassword(),
				t.getActive(),
				t.getIdpersona(),
				t.getIdrol());
	}
	@Override
	public int update(Usuario t) {
		String SQL= "UPDATE usuario SET password=?, active=?, idrol=? WHERE idusuario =?";
		return jdbcTemplate.update(SQL, 
				t.getPassword(),
				t.getActive(),
				t.getIdrol(),
				t.getIdusuario());
	}

	@Override
	public int delete(int id) {
		String SQL= "DELETE FROM usuario WHERE idusuario =?";
		return jdbcTemplate.update(SQL,id);
	}

	@Override
	public Usuario read(int id) {
		String SQL= "SELECT *FROM usuario WHERE idusuario=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Usuario>(Usuario.class));
	}

	@Override
	public List<Map<String,Object>> readAll() {
		String SQL= "SELECT u.idusuario, u.correo, p.idpersona, p.nombres, p.apellidos, p.sexo, p.edad, p.dni, p.centro_estudios, p.carrera, r.idrol, r.nomrol, u.correo, "
				+ "u.active, d.nom_dpto, dd.nomdistrito FROM usuario as u, persona as p, rol as r, departamento as d, distrito as dd WHERE u.idrol=r.idrol and " 
				+ 	"u.idpersona = p.idpersona and u.active=1 and p.iddepartamento = d.iddepartamento and p.iddistrito=dd.iddistrito";
		return  jdbcTemplate.queryForList(SQL);
	}

	@Override
	public List<Map<String, Object>> login(String correo, String password) {
		String SQL ="SELECT u.idusuario, u.correo, u.password, p.idpersona, "
				+ "p.nombres, p.apellidos, r.idrol, r.nomrol FROM usuario as u, persona as p, rol as r WHERE u.idrol=r.idrol and " 
				+ 	"u.idpersona = p.idpersona and u.active=1 and u.correo=? and u.password=?";
		return jdbcTemplate.queryForList(SQL);
	}
	@Override
	public Usuario findUserByEmail(String correo) {
		String SQL= "SELECT *FROM usuario WHERE correo=?";
		try {
			return jdbcTemplate.queryForObject(SQL, new Object[] {correo}, new BeanPropertyRowMapper<Usuario>(Usuario.class));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	@Override
	public List<Map<String,Object>> findUserbyRole(Rol role) {
		// TODO Auto-generated method stub
		String SQL= "SELECT u.idusuario, u.correo, u.password, u.active, u.idpersona, u.idrol FROM usuario as u " + 
				"INNER JOIN rol as r ON r.idrol=u.idrol " + 
				"INNER JOIN persona as p ON u.idpersona=p.idpersona " + 
				"WHERE r.nomrol=?";
		return jdbcTemplate.queryForList(SQL, role.getNomrol());
	}
	
}
