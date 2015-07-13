package beans;

public class Personas {
	
	private int idpersona;
	private String usuarioPersona;
	private String contrase�aPersona;
	private String nombrePersona;
	private String apePatPersona;
	private String apeMatPersona;
	
	public Personas(int idpersona, String usuarioPersona,
			String contrase�aPersona, String nombrePersona,
			String apePatPersona, String apeMatPersona) 
	{
		this.idpersona = idpersona;
		this.usuarioPersona = usuarioPersona;
		this.contrase�aPersona = contrase�aPersona;
		this.nombrePersona = nombrePersona;
		this.apePatPersona = apePatPersona;
		this.apeMatPersona = apeMatPersona;
	}
	public int getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
	public String getUsuarioPersona() {
		return usuarioPersona;
	}
	public void setUsuarioPersona(String usuarioPersona) {
		this.usuarioPersona = usuarioPersona;
	}
	public String getContrase�aPersona() {
		return contrase�aPersona;
	}
	public void setContrase�aPersona(String contrase�aPersona) {
		this.contrase�aPersona = contrase�aPersona;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getApePatPersona() {
		return apePatPersona;
	}
	public void setApePatPersona(String apePatPersona) {
		this.apePatPersona = apePatPersona;
	}
	public String getApeMatPersona() {
		return apeMatPersona;
	}
	public void setApeMatPersona(String apeMatPersona) {
		this.apeMatPersona = apeMatPersona;
	}
}
