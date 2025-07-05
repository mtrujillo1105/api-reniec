package com.laprotectora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "canal")
public class Canal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String codigo;
	
	@Column
	private String empresa;
	
	@Column
	private String descripcion;
	
	@Column
	private String estado;

	public Canal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Canal(int id, String codigo, String empresa, String descripcion) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.empresa = empresa;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Canal [id=" + id + ", codigo=" + codigo + ", empresa=" + empresa + ", descripcion=" + descripcion + "]";
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
