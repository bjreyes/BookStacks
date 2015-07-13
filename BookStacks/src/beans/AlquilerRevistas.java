package beans;

public class AlquilerRevistas {
	private int idRevista;
	private int idAlq;
	private String codAlq; 
	private String fechaEntrega; 
	private String fechaSalida; 
	private double montoPagar; 
	private int idUsuario;
	private String estadoAlq;
	
	public AlquilerRevistas(int idRevista, int idAlq, String codAlq,
			String fechaEntrega, String fechaSalida, double montoPagar,
			int idUsuario, String estadoAlq) {
		this.idRevista = idRevista;
		this.idAlq = idAlq;
		this.codAlq = codAlq;
		this.fechaEntrega = fechaEntrega;
		this.fechaSalida = fechaSalida;
		this.montoPagar = montoPagar;
		this.idUsuario = idUsuario;
		this.estadoAlq = estadoAlq;
	}

	public int getIdRevista() {
		return idRevista;
	}

	public void setIdRevista(int idRevista) {
		this.idRevista = idRevista;
	}

	public int getIdAlq() {
		return idAlq;
	}

	public void setIdAlq(int idAlq) {
		this.idAlq = idAlq;
	}

	public String getCodAlq() {
		return codAlq;
	}

	public void setCodAlq(String codAlq) {
		this.codAlq = codAlq;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getMontoPagar() {
		return montoPagar;
	}

	public void setMontoPagar(double montoPagar) {
		this.montoPagar = montoPagar;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEstadoAlq() {
		return estadoAlq;
	}

	public void setEstadoAlq(String estadoAlq) {
		this.estadoAlq = estadoAlq;
	}
}
