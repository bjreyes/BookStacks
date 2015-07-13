package beans;

public class Discos {

	private int idDisco;
	private String codDisco;
	private String nomDisco;
	private String tama�oDisco;
	private int genero;
	private double precioPorDia;
	
	public Discos(int idDisco, String codDisco, String nomDisco,
			String tama�oDisco, int genero, double precioPorDia) {
		this.idDisco = idDisco;
		this.codDisco = codDisco;
		this.nomDisco = nomDisco;
		this.tama�oDisco = tama�oDisco;
		this.genero = genero;
		this.precioPorDia = precioPorDia;
	}
	
	public int getIdDisco() {
		return idDisco;
	}
	public void setIdDisco(int idDisco) {
		this.idDisco = idDisco;
	}
	public String getCodDisco() {
		return codDisco;
	}
	public void setCodDisco(String codDisco) {
		this.codDisco = codDisco;
	}
	public String getNomDisco() {
		return nomDisco;
	}
	public void setNomDisco(String nomDisco) {
		this.nomDisco = nomDisco;
	}
	public String getTama�oDisco() {
		return tama�oDisco;
	}
	public void setTama�oDisco(String tama�oDisco) {
		this.tama�oDisco = tama�oDisco;
	}
	public int getGenero() {
		return genero;
	}
	public void setGenero(int genero) {
		this.genero = genero;
	}
	public double getPrecioPorDia() {
		return precioPorDia;
	}
	public void setPrecioPorDia(double precioPorDia) {
		this.precioPorDia = precioPorDia;
	}
}
