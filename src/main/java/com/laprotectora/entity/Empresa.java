package com.laprotectora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String codigo;
	
	@Column
	private String codigo_reniec;
	
	@Column
	private String descripcion;
	
	@Column
	private String servidor;
	
	@Column
	private String estado;

	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empresa(int id, String codigo, String descripcion, String estado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estado = estado;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

}
