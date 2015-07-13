package beans;

public class Personas {
	
	private int idpersona;
	private String usuarioPersona;
	private String contraseñaPersona;
	private String nombrePersona;
	private String apePatPersona;
	private String apeMatPersona;
	
	public Personas(int idpersona, String usuarioPersona,
			String contraseñaPersona, String nombrePersona,
			String apePatPersona, String apeMatPersona) 
	{
		this.idpersona = idpersona;
		this.usuarioPersona = usuarioPersona;
		this.contraseñaPersona = contraseñaPersona;
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
	public String getContraseñaPersona() {
		return contraseñaPersona;
	}
	public void setContraseñaPersona(String contraseñaPersona) {
		this.contraseñaPersona = contraseñaPersona;
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
