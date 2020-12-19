package pe.org.system.model;

public class Asistencia {
private int idasistencia;
private String fecha;
private String hora;
private int idactividad;
private int idusuario;
private int iddistrito;
private int idpersona;
public Asistencia() {
}
public Asistencia(int idasistencia, String fecha, String hora, int idactividad, int idusuario, int iddistrito,
		int idpersona) {
	super();
	this.idasistencia = idasistencia;
	this.fecha = fecha;
	this.hora = hora;
	this.idactividad = idactividad;
	this.idusuario = idusuario;
	this.iddistrito = iddistrito;
	this.idpersona = idpersona;
}
public int getIdasistencia() {
	return idasistencia;
}
public void setIdasistencia(int idasistencia) {
	this.idasistencia = idasistencia;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getHora() {
	return hora;
}
public void setHora(String hora) {
	this.hora = hora;
}
public int getIdactividad() {
	return idactividad;
}
public void setIdactividad(int idactividad) {
	this.idactividad = idactividad;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public int getIddistrito() {
	return iddistrito;
}
public void setIddistrito(int iddistrito) {
	this.iddistrito = iddistrito;
}
public int getIdpersona() {
	return idpersona;
}
public void setIdpersona(int idpersona) {
	this.idpersona = idpersona;
}

}
