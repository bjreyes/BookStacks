package beans;

public class Recomendaciones {
	private int idrecomendacion;
	private String tipObjRecomendacion;
	private String nomObjRecomendacion;
	private String autorObjRecomendacion;
	private int idpersona;
	
	
	public Recomendaciones(int idrecomendacion, String tipObjRecomendacion,
			String nomObjRecomendacion, String autorObjRecomendacion,
			int idpersona) {
		super();
		this.idrecomendacion = idrecomendacion;
		this.tipObjRecomendacion = tipObjRecomendacion;
		this.nomObjRecomendacion = nomObjRecomendacion;
		this.autorObjRecomendacion = autorObjRecomendacion;
		this.idpersona = idpersona;
	}
	
	public int getIdrecomendacion() {
		return idrecomendacion;
	}
	public void setIdrecomendacion(int idrecomendacion) {
		this.idrecomendacion = idrecomendacion;
	}
	public String getTipObjRecomendacion() {
		return tipObjRecomendacion;
	}
	public void setTipObjRecomendacion(String tipObjRecomendacion) {
		this.tipObjRecomendacion = tipObjRecomendacion;
	}
	public String getNomObjRecomendacion() {
		return nomObjRecomendacion;
	}
	public void setNomObjRecomendacion(String nomObjRecomendacion) {
		this.nomObjRecomendacion = nomObjRecomendacion;
	}
	public String getAutorObjRecomendacion() {
		return autorObjRecomendacion;
	}
	public void setAutorObjRecomendacion(String autorObjRecomendacion) {
		this.autorObjRecomendacion = autorObjRecomendacion;
	}
	public int getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

}
