package beans;

public class Generos {
	private int id;
	private String genero;
	
	public Generos(int id, String genero) {
		this.id = id;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
