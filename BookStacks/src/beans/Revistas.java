package beans;

public class Revistas {
	
	private int idRevista;
	private String codRevista;
	private String tituloRevista;
	private String edicionRevista;
	private int numPaginas;
	private int genero;
	private double precioPorDia;
	
	public Revistas(int idRevista, String codRevista, String tituloRevista,
			String edicionRevista, int numPaginas, int genero,
			double precioPorDia) {
		this.idRevista = idRevista;
		this.codRevista = codRevista;
		this.tituloRevista = tituloRevista;
		this.edicionRevista = edicionRevista;
		this.numPaginas = numPaginas;
		this.genero = genero;
		this.precioPorDia = precioPorDia;
	}
	
	public int getIdRevista() {
		return idRevista;
	}
	public void setIdRevista(int idRevista) {
		this.idRevista = idRevista;
	}
	public String getCodRevista() {
		return codRevista;
	}
	public void setCodRevista(String codRevista) {
		this.codRevista = codRevista;
	}
	public String getTituloRevista() {
		return tituloRevista;
	}
	public void setTituloRevista(String tituloRevista) {
		this.tituloRevista = tituloRevista;
	}
	public String getEdicionRevista() {
		return edicionRevista;
	}
	public void setEdicionRevista(String edicionRevista) {
		this.edicionRevista = edicionRevista;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
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
