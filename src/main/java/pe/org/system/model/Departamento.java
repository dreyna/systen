package pe.org.system.model;

public class Departamento {
private int iddepartamento;
private String nom_dpto;
public Departamento() {
	super();
}
public Departamento(int iddepartamento, String nom_dpto) {
	super();
	this.iddepartamento = iddepartamento;
	this.nom_dpto = nom_dpto;
}
public int getIddepartamento() {
	return iddepartamento;
}
public void setIddepartamento(int iddepartamento) {
	this.iddepartamento = iddepartamento;
}
public String getNom_dpto() {
	return nom_dpto;
}
public void setNom_dpto(String nom_dpto) {
	this.nom_dpto = nom_dpto;
}

}
