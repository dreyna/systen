package pe.org.system.model;

public class Datos {
private String nombres;
private String apellidos;
private String correo;
private String dni;
private int edad;
private int iddepartamento;
private String sexo;
private String cestudios;
private String carrera;
private String telefono;
private String periodo1;
private String periodo2;
private String password;
private int idrol;
private int iddistrito;
public Datos() {
}

public Datos(String nombres, String apellidos, String correo, String dni, int edad, int iddepartamento, String sexo,
		String cestudios, String carrera, String telefono, String periodo1, String periodo2, String password, int idrol,
		int iddistrito) {
	super();
	this.nombres = nombres;
	this.apellidos = apellidos;
	this.correo = correo;
	this.dni = dni;
	this.edad = edad;
	this.iddepartamento = iddepartamento;
	this.sexo = sexo;
	this.cestudios = cestudios;
	this.carrera = carrera;
	this.telefono = telefono;
	this.periodo1 = periodo1;
	this.periodo2 = periodo2;
	this.password = password;
	this.idrol = idrol;
	this.iddistrito = iddistrito;
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

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public int getEdad() {
	return edad;
}

public void setEdad(int edad) {
	this.edad = edad;
}

public int getIddepartamento() {
	return iddepartamento;
}

public void setIddepartamento(int iddepartamento) {
	this.iddepartamento = iddepartamento;
}

public String getSexo() {
	return sexo;
}

public void setSexo(String sexo) {
	this.sexo = sexo;
}

public String getCestudios() {
	return cestudios;
}

public void setCestudios(String cestudios) {
	this.cestudios = cestudios;
}

public String getCarrera() {
	return carrera;
}

public void setCarrera(String carrera) {
	this.carrera = carrera;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getPeriodo1() {
	return periodo1;
}

public void setPeriodo1(String periodo1) {
	this.periodo1 = periodo1;
}

public String getPeriodo2() {
	return periodo2;
}

public void setPeriodo2(String periodo2) {
	this.periodo2 = periodo2;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getIdrol() {
	return idrol;
}

public void setIdrol(int idrol) {
	this.idrol = idrol;
}

public int getIddistrito() {
	return iddistrito;
}

public void setIddistrito(int iddistrito) {
	this.iddistrito = iddistrito;
}
}
