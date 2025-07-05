package com.laprotectora.dto;

public class CLRequest {

	private String empresa;
	private String canal;
	private String dni;
	private String tipo_consulta;//1: basico, 2 : completo
	private String foto_firma;//0: sin imagenes, 1: con imagenes
	private String codigo_reniec;
	private String servidor;
	
	public CLRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CLRequest(String empresa, String canal, String dni, String codigo_reniec, String servidor) {
		super();
		this.empresa = empresa;
		this.canal = canal;
		this.dni = dni;
		this.codigo_reniec = codigo_reniec;
		this.servidor = servidor;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodigo_reniec() {
		return codigo_reniec;
	}

	public void setCodigo_reniec(String codigo_reniec) {
		this.codigo_reniec = codigo_reniec;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getTipo_consulta() {
		return tipo_consulta;
	}

	public void setTipo_consulta(String tipo_consulta) {
		this.tipo_consulta = tipo_consulta;
	}

	public String getFoto_firma() {
		return foto_firma;
	}

	public void setFoto_firma(String foto_firma) {
		this.foto_firma = foto_firma;
	}

	@Override
	public String toString() {
		return "CLRequest [empresa=" + empresa + ", canal=" + canal + ", dni=" + dni + ", tipo_consulta="
				+ tipo_consulta + ", foto_firma=" + foto_firma + ", codigo_reniec=" + codigo_reniec + ", servidor="
				+ servidor + "]";
	}
	
	
}
