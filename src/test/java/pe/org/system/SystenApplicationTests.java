package pe.org.system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.google.gson.Gson;

import pe.org.system.dao.ActividadDAO;
import pe.org.system.dao.DepartamentoDAO;
import pe.org.system.dao.RolDAO;
import pe.org.system.dao.UsuarioDAO;
import pe.org.system.model.Rol;


@SpringBootTest
class SystenApplicationTests {
@Autowired
BCryptPasswordEncoder passwordEncoder;

@Autowired
private DepartamentoDAO rolDao;
Gson g = new Gson();
Rol rol = new Rol();
	@Test
	void contextLoads() {
		rol.setNomrol("GERENTE FINANCIERO");
		System.out.println(rolDao.getIdDepto(10));

	}

}
