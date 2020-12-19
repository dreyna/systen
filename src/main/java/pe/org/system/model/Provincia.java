package pe.org.system.model;

public class Provincia {
private int idprovincia;
private String nomprovincia;
public Provincia() {
	super();
}
public Provincia(int idprovincia, String nomprovincia) {
	super();
	this.idprovincia = idprovincia;
	this.nomprovincia = nomprovincia;
}
public int getIdprovincia() {
	return idprovincia;
}
public void setIdprovincia(int idprovincia) {
	this.idprovincia = idprovincia;
}
public String getNomprovincia() {
	return nomprovincia;
}
public void setNomprovincia(String nomprovincia) {
	this.nomprovincia = nomprovincia;
}

}
