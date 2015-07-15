package beans;

public class Libro {
	private String codLibro;
	private String tituloLibro;
	private int numPaginas;
	private String idioma;
	private int autor;
	private int genero;
	private double precioPorDia;
	
	public Libro(String codLibro, String tituloLibro, int numPaginas,
			String idioma, int autor, int genero, double precioPorDia) {
		this.codLibro = codLibro;
		this.tituloLibro = tituloLibro;
		this.numPaginas = numPaginas;
		this.idioma = idioma;
		this.autor = autor;
		this.genero = genero;
		this.precioPorDia = precioPorDia;
	}
	public String getCodLibro() {
		return codLibro;
	}
	public void setCodLibro(String codLibro) {
		this.codLibro = codLibro;
	}
	public String getTituloLibro() {
		return tituloLibro;
	}
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getAutor() {
		return autor;
	}
	public void setAutor(int autor) {
		this.autor = autor;
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
