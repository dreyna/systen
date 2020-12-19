package pe.org.system.model;

public class Distrito {
private int iddistrito;
private String nomdistrito;
public Distrito() {
	super();
}
public Distrito(int iddistrito, String nomdistrito) {
	super();
	this.iddistrito = iddistrito;
	this.nomdistrito = nomdistrito;
}
public int getIddistrito() {
	return iddistrito;
}
public void setIddistrito(int iddistrito) {
	this.iddistrito = iddistrito;
}
public String getNomdistrito() {
	return nomdistrito;
}
public void setNomdistrito(String nomdistrito) {
	this.nomdistrito = nomdistrito;
}

}
