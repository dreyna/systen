package pe.org.system.model;

public class Actividad {
private int idactividad;
private String descripcion;
private String fecha;
private String hora;
private String estado;
private int iddepartamento;
private int iddistrito;
public Actividad() {
}
public Actividad(int idactividad, String descripcion, String fecha, String hora, String estado, int iddepartamento,
		int iddistrito) {
	this.idactividad = idactividad;
	this.descripcion = descripcion;
	this.fecha = fecha;
	this.hora = hora;
	this.estado = estado;
	this.iddepartamento = iddepartamento;
	this.iddistrito = iddistrito;
}
public int getIdactividad() {
	return idactividad;
}
public void setIdactividad(int idactividad) {
	this.idactividad = idactividad;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
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
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public int getIddepartamento() {
	return iddepartamento;
}
public void setIddepartamento(int iddepartamento) {
	this.iddepartamento = iddepartamento;
}
public int getIddistrito() {
	return iddistrito;
}
public void setIddistrito(int iddistrito) {
	this.iddistrito = iddistrito;
}

}
