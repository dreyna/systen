package pe.org.system.model;

public class Usuario {
private int idusuario;
private String correo;
private String password;
private int active;
private int idpersona;
private int idrol;
public Usuario() {
}
public Usuario(int idusuario, String correo, String password, int active, int idpersona, int idrol) {
	super();
	this.idusuario = idusuario;
	this.correo = correo;
	this.password = password;
	this.active = active;
	this.idpersona = idpersona;
	this.idrol = idrol;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}
public int getIdpersona() {
	return idpersona;
}
public void setIdpersona(int idpersona) {
	this.idpersona = idpersona;
}
public int getIdrol() {
	return idrol;
}
public void setIdrol(int idrol) {
	this.idrol = idrol;
}


}
