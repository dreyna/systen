package pe.org.system.model;

public class Persona {
private int idpersona;
private String dni;
private String nombres;
private String apellidos;
private int edad;
private String sexo;
private String telefono;
private String centro_estudios;
private String periodo;
private String carrera;
private int iddepartamento;
private int iddistrito;
public Persona() {
}
public Persona(int idpersona, String dni, String nombres, String apellidos, int edad, String sexo, String telefono,
		String centro_estudios, String periodo, String carrera, int iddepartamento, int iddistrito) {
	this.idpersona = idpersona;
	this.dni = dni;
	this.nombres = nombres;
	this.apellidos = apellidos;
	this.edad = edad;
	this.sexo = sexo;
	this.telefono = telefono;
	this.centro_estudios = centro_estudios;
	this.periodo = periodo;
	this.carrera = carrera;
	this.iddepartamento = iddepartamento;
	this.iddistrito = iddistrito;
}
public int getIdpersona() {
	return idpersona;
}
public void setIdpersona(int idpersona) {
	this.idpersona = idpersona;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getCentro_estudios() {
	return centro_estudios;
}
public void setCentro_estudios(String centro_estudios) {
	this.centro_estudios = centro_estudios;
}
public String getPeriodo() {
	return periodo;
}
public void setPeriodo(String periodo) {
	this.periodo = periodo;
}
public String getCarrera() {
	return carrera;
}
public void setCarrera(String carrera) {
	this.carrera = carrera;
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
