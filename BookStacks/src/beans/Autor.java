package beans;

public class Autor {
 private int idAutor;
 private String nomAutor;
 private String apePatAutor;
 private String apeMatAutor;
 
public Autor(int idAutor, String nomAutor, String apePatAutor,
		String apeMatAutor) {
	this.idAutor = idAutor;
	this.nomAutor = nomAutor;
	this.apePatAutor = apePatAutor;
	this.apeMatAutor = apeMatAutor;
}

public int getIdAutor() {
	return idAutor;
}
public void setIdAutor(int idAutor) {
	this.idAutor = idAutor;
}
public String getNomAutor() {
	return nomAutor;
}
public void setNomAutor(String nomAutor) {
	this.nomAutor = nomAutor;
}
public String getApePatAutor() {
	return apePatAutor;
}
public void setApePatAutor(String apePatAutor) {
	this.apePatAutor = apePatAutor;
}
public String getApeMatAutor() {
	return apeMatAutor;
}
public void setApeMatAutor(String apeMatAutor) {
	this.apeMatAutor = apeMatAutor;
}
 
 
}
