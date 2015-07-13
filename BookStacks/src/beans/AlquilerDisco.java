package beans;

public class AlquilerDisco {

	private int idDisco;
	private int idAlq;
	private String codAlq; 
	private String fechaEntrega; 
	private String fechaSalida; 
	private double montoPagar; 
	private int idUsuario;
	private String estadoAlq;
	public AlquilerDisco(int idDisco, int idAlq, String codAlq,
			String fechaEntrega, String fechaSalida, double montoPagar,
			int idUsuario, String estadoAlq) {
		this.idDisco = idDisco;
		this.idAlq = idAlq;
		this.codAlq = codAlq;
		this.fechaEntrega = fechaEntrega;
		this.fechaSalida = fechaSalida;
		this.montoPagar = montoPagar;
		this.idUsuario = idUsuario;
		this.estadoAlq = estadoAlq;
	}
	
	public int getIdDisco() {
		return idDisco;
	}
	public void setIdDisco(int idDisco) {
		this.idDisco = idDisco;
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
