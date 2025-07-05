package com.laprotectora.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CLResponse {

	private int codigo;
	
	private boolean status;
	
	private String mensaje;
	
	private List<CLPerson> data;
	
	public CLResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CLResponse(int codigo,String mensaje, boolean status, List<CLPerson> data) {
		super();
		this.codigo = codigo;
		this.status = status;
		this.mensaje = mensaje;
		this.data = data;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<CLPerson> getData() {
		return data;
	}

	public void setData(List<CLPerson> data) {
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CLResponse [codigo=" + codigo + ", mensaje=" + mensaje + ", status=" + status + ", data=" + data.toString() + "]";
	}
	
}
