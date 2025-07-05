package com.laprotectora.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CLPerson {
	
	private String cod_error;
	private String error;
	private String dni;
	private String digito;
	private String apellido_paterno;
	private String apellido_casada;
	private String apellido_materno;
	private String nombres;
	private String cod_continente_domicilio;
	private String cod_pais_domicilio;
	private String cod_departamento_domicilio;
	private String cod_provincia_domicilio;
	private String cod_distrito_domicilio;
	private String continente_domicilio;
	private String pais_domicilio;
	private String departamento_domicilio;
	private String provincia_domicilio;
	private String distrito_domicilio;
	private String cod_estado_civil;
	private String estado_civil;
	private String cod_grado_instruccion;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 	
	private String grado_instruccion;
	
	private String estatura;
	private String cod_sexo;
	private String sexo;
	private String cod_continente_nacimiento;
	private String cod_pais_nacimiento;
	private String cod_departamento_nacimiento;
	private String cod_provincia_nacimiento;
	private String cod_distrito_nacimiento;
	private String continente_nacimiento;
	private String pais_nacimiento;
	private String departamento_nacimiento;
	private String provincia_nacimiento;
	private String distrito_nacimiento;
	private String fecha_nacimiento;
	private String nombre_padre;
	private String nombre_madre;
	private String fecha_inscripcion;
	private String fecha_emision;
	private String cod_constancia_votacion;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 	
	private String constancia_votacion;
	
	private String cod_restriccion;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 	
	private String restriccion;
	
	private String cod_direccion;
	private String direccion;
	private String nombre_direccion;
	private String numero_direccion;
	private String block_chalet;
	private String interior;
	private String nombre_urbanizacion;
	private String etapa;
	private String manzana;
	private String lote;
	private String cod_block;
	private String block;
	private String cod_departamento;
	private String departamento;
	private String cod_urbanizacion;
	private String urbanizacion;
	private String domicilio;
	private String reservado;
	private String foto;
	private String firma;
	
	public CLPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CLPerson(CLPerson persona,String tipo_consulta_usu) {
		this.cod_error = persona.getCod_error();
		this.error = persona.getError();
		this.dni = persona.getDni();
		this.digito = persona.getDigito();
		this.apellido_paterno = persona.getApellido_paterno();
		this.apellido_casada = persona.getApellido_casada();
		this.apellido_materno = persona.getApellido_materno();
		this.nombres = persona.getNombres();
		this.cod_continente_domicilio = persona.getCod_continente_domicilio();
		this.cod_pais_domicilio = persona.getCod_pais_domicilio();
		this.cod_departamento_domicilio = persona.getCod_departamento_domicilio();
		this.cod_provincia_domicilio = persona.getCod_provincia_domicilio();
		this.cod_distrito_domicilio = persona.getCod_distrito_domicilio();
		this.continente_domicilio = persona.getContinente_domicilio();
		this.pais_domicilio = persona.getPais_domicilio();
		this.departamento_domicilio = persona.getDepartamento_domicilio();
		this.provincia_domicilio = persona.getProvincia_domicilio();
		this.distrito_domicilio = persona.getDistrito_domicilio();
		this.cod_estado_civil = persona.getCod_estado_civil();
		this.estado_civil = persona.getEstado_civil();
		this.cod_grado_instruccion = persona.getCod_grado_instruccion();
		
		if(tipo_consulta_usu.equalsIgnoreCase("2"))//2: Completa
			this.grado_instruccion = persona.getGrado_instruccion();
		
		this.estatura = persona.getEstatura();
		this.cod_sexo = persona.getCod_sexo();
		this.sexo = persona.getSexo();
		this.cod_continente_nacimiento = persona.getCod_continente_nacimiento();
		this.cod_pais_nacimiento = persona.getCod_pais_nacimiento();
		this.cod_departamento_nacimiento = persona.getCod_departamento_nacimiento();
		this.cod_provincia_nacimiento = persona.getCod_provincia_nacimiento();
		this.cod_distrito_nacimiento = persona.getCod_distrito_nacimiento();
		this.continente_nacimiento = persona.getContinente_nacimiento();
		this.pais_nacimiento = persona.getPais_nacimiento();
		this.departamento_nacimiento = persona.getDepartamento_nacimiento();
		this.provincia_nacimiento = persona.getProvincia_nacimiento();
		this.distrito_nacimiento = persona.getDistrito_nacimiento();
		this.fecha_nacimiento = persona.getFecha_nacimiento();
		this.nombre_padre = persona.getNombre_padre();
		this.nombre_madre = persona.getNombre_madre();
		this.fecha_inscripcion = persona.getFecha_inscripcion();
		this.fecha_emision = persona.getFecha_emision();
		this.cod_constancia_votacion = persona.getCod_constancia_votacion();
		
		if(tipo_consulta_usu.equalsIgnoreCase("2"))//2: Completa
			this.constancia_votacion = persona.getConstancia_votacion();
		
		this.cod_restriccion = persona.getCod_restriccion();
		
		if(tipo_consulta_usu.equalsIgnoreCase("2"))//2: Completa
			this.restriccion = persona.getRestriccion();
		
		this.cod_direccion = persona.getCod_direccion();
		this.direccion = persona.getDireccion(); 
		this.nombre_direccion = persona.getNombre_direccion();
		this.numero_direccion = persona.getNumero_direccion();
		this.block_chalet = persona.getBlock_chalet();
		this.interior = persona.getInterior();
		this.nombre_urbanizacion = persona.getNombre_urbanizacion();
		this.etapa = persona.getEtapa();
		this.manzana = persona.getManzana();
		this.lote = persona.getLote();
		this.cod_block = persona.getCod_block();
		this.block = persona.getBlock();
		this.cod_departamento = persona.getCod_departamento();
		this.departamento = persona.getDepartamento();
		this.cod_urbanizacion = persona.getCod_urbanizacion();
		this.urbanizacion = persona.getUrbanizacion();
		this.domicilio = persona.getDomicilio();
		this.reservado = persona.getReservado();
		this.foto = persona.getFoto();
		this.firma = persona.getFirma();
		
	}
	public String getCod_error() {
		return cod_error;
	}
	public void setCod_error(String cod_error) {
		this.cod_error = cod_error;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDigito() {
		return digito;
	}
	public void setDigito(String digito) {
		this.digito = digito;
	}
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getApellido_casada() {
		return apellido_casada;
	}
	public void setApellido_casada(String apellido_casada) {
		this.apellido_casada = apellido_casada;
	}
	public String getApellido_materno() {
		return apellido_materno;
	}
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public void setCod_sexo(String cod_sexo) {
		this.cod_sexo = cod_sexo;
	}
	public String getSexo() {
		return sexo;
	}
	public String getCod_continente_domicilio() {
		return cod_continente_domicilio;
	}
	public void setCod_continente_domicilio(String cod_continente_domicilio) {
		this.cod_continente_domicilio = cod_continente_domicilio;
	}

	public String getCod_pais_domicilio() {
		return cod_pais_domicilio;
	}

	public void setCod_pais_domicilio(String cod_pais_domicilio) {
		this.cod_pais_domicilio = cod_pais_domicilio;
	}

	public String getCod_departamento_domicilio() {
		return cod_departamento_domicilio;
	}

	public void setCod_departamento_domicilio(String cod_departamento_domicilio) {
		this.cod_departamento_domicilio = cod_departamento_domicilio;
	}

	public String getCod_provincia_domicilio() {
		return cod_provincia_domicilio;
	}

	public void setCod_provincia_domicilio(String cod_provincia_domicilio) {
		this.cod_provincia_domicilio = cod_provincia_domicilio;
	}

	public String getCod_distrito_domicilio() {
		return cod_distrito_domicilio;
	}

	public void setCod_distrito_domicilio(String cod_distrito_domicilio) {
		this.cod_distrito_domicilio = cod_distrito_domicilio;
	}

	public String getContinente_domicilio() {
		return continente_domicilio;
	}

	public void setContinente_domicilio(String continente_domicilio) {
		this.continente_domicilio = continente_domicilio;
	}

	public String getPais_domicilio() {
		return pais_domicilio;
	}

	public void setPais_domicilio(String pais_domicilio) {
		this.pais_domicilio = pais_domicilio;
	}

	public String getDepartamento_domicilio() {
		return departamento_domicilio;
	}

	public void setDepartamento_domicilio(String departamento_domicilio) {
		this.departamento_domicilio = departamento_domicilio;
	}

	public String getProvincia_domicilio() {
		return provincia_domicilio;
	}

	public void setProvincia_domicilio(String provincia_domicilio) {
		this.provincia_domicilio = provincia_domicilio;
	}

	public String getDistrito_domicilio() {
		return distrito_domicilio;
	}

	public void setDistrito_domicilio(String distrito_domicilio) {
		this.distrito_domicilio = distrito_domicilio;
	}

	public String getCod_estado_civil() {
		return cod_estado_civil;
	}

	public void setCod_estado_civil(String cod_estado_civil) {
		this.cod_estado_civil = cod_estado_civil;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getCod_grado_instruccion() {
		return cod_grado_instruccion;
	}

	public void setCod_grado_instruccion(String cod_grado_instruccion) {
		this.cod_grado_instruccion = cod_grado_instruccion;
	}

	public String getGrado_instruccion() {
		return grado_instruccion;
	}

	public void setGrado_instruccion(String grado_instruccion) {
		this.grado_instruccion = grado_instruccion;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public String getCod_sexo() {
		return cod_sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCod_continente_nacimiento() {
		return cod_continente_nacimiento;
	}

	public void setCod_continente_nacimiento(String cod_continente_nacimiento) {
		this.cod_continente_nacimiento = cod_continente_nacimiento;
	}

	public String getCod_pais_nacimiento() {
		return cod_pais_nacimiento;
	}

	public void setCod_pais_nacimiento(String cod_pais_nacimiento) {
		this.cod_pais_nacimiento = cod_pais_nacimiento;
	}

	public String getCod_departamento_nacimiento() {
		return cod_departamento_nacimiento;
	}

	public void setCod_departamento_nacimiento(String cod_departamento_nacimiento) {
		this.cod_departamento_nacimiento = cod_departamento_nacimiento;
	}

	public String getCod_provincia_nacimiento() {
		return cod_provincia_nacimiento;
	}

	public void setCod_provincia_nacimiento(String cod_provincia_nacimiento) {
		this.cod_provincia_nacimiento = cod_provincia_nacimiento;
	}

	public String getCod_distrito_nacimiento() {
		return cod_distrito_nacimiento;
	}

	public void setCod_distrito_nacimiento(String cod_distrito_nacimiento) {
		this.cod_distrito_nacimiento = cod_distrito_nacimiento;
	}

	public String getContinente_nacimiento() {
		return continente_nacimiento;
	}

	public void setContinente_nacimiento(String continente_nacimiento) {
		this.continente_nacimiento = continente_nacimiento;
	}

	public String getPais_nacimiento() {
		return pais_nacimiento;
	}

	public void setPais_nacimiento(String pais_nacimiento) {
		this.pais_nacimiento = pais_nacimiento;
	}

	public String getDepartamento_nacimiento() {
		return departamento_nacimiento;
	}

	public void setDepartamento_nacimiento(String departamento_nacimiento) {
		this.departamento_nacimiento = departamento_nacimiento;
	}

	public String getProvincia_nacimiento() {
		return provincia_nacimiento;
	}

	public void setProvincia_nacimiento(String provincia_nacimiento) {
		this.provincia_nacimiento = provincia_nacimiento;
	}

	public String getDistrito_nacimiento() {
		return distrito_nacimiento;
	}

	public void setDistrito_nacimiento(String distrito_nacimiento) {
		this.distrito_nacimiento = distrito_nacimiento;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNombre_padre() {
		return nombre_padre;
	}

	public void setNombre_padre(String nombre_padre) {
		this.nombre_padre = nombre_padre;
	}

	public String getNombre_madre() {
		return nombre_madre;
	}

	public void setNombre_madre(String nombre_madre) {
		this.nombre_madre = nombre_madre;
	}

	public String getFecha_inscripcion() {
		return fecha_inscripcion;
	}

	public void setFecha_inscripcion(String fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}

	public String getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(String fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public String getCod_constancia_votacion() {
		return cod_constancia_votacion;
	}

	public void setCod_constancia_votacion(String cod_constancia_votacion) {
		this.cod_constancia_votacion = cod_constancia_votacion;
	}

	public String getConstancia_votacion() {
		return constancia_votacion;
	}

	public void setConstancia_votacion(String constancia_votacion) {
		this.constancia_votacion = constancia_votacion;
	}

	public String getCod_restriccion() {
		return cod_restriccion;
	}

	public void setCod_restriccion(String cod_restriccion) {
		this.cod_restriccion = cod_restriccion;
	}

	public String getRestriccion() {
		return restriccion;
	}

	public void setRestriccion(String restriccion) {
		this.restriccion = restriccion;
	}

	public String getCod_direccion() {
		return cod_direccion;
	}

	public void setCod_direccion(String cod_direccion) {
		this.cod_direccion = cod_direccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre_direccion() {
		return nombre_direccion;
	}

	public void setNombre_direccion(String nombre_direccion) {
		this.nombre_direccion = nombre_direccion;
	}

	public String getNumero_direccion() {
		return numero_direccion;
	}

	public void setNumero_direccion(String numero_direccion) {
		this.numero_direccion = numero_direccion;
	}

	public String getBlock_chalet() {
		return block_chalet;
	}

	public void setBlock_chalet(String block_chalet) {
		this.block_chalet = block_chalet;
	}

	public String getInterior() {
		return interior;
	}

	public void setInterior(String interior) {
		this.interior = interior;
	}

	public String getNombre_urbanizacion() {
		return nombre_urbanizacion;
	}

	public void setNombre_urbanizacion(String nombre_urbanizacion) {
		this.nombre_urbanizacion = nombre_urbanizacion;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public String getManzana() {
		return manzana;
	}

	public void setManzana(String manzana) {
		this.manzana = manzana;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getCod_block() {
		return cod_block;
	}

	public void setCod_block(String cod_block) {
		this.cod_block = cod_block;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getCod_departamento() {
		return cod_departamento;
	}

	public void setCod_departamento(String cod_departamento) {
		this.cod_departamento = cod_departamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCod_urbanizacion() {
		return cod_urbanizacion;
	}

	public void setCod_urbanizacion(String cod_urbanizacion) {
		this.cod_urbanizacion = cod_urbanizacion;
	}

	public String getUrbanizacion() {
		return urbanizacion;
	}

	public void setUrbanizacion(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getReservado() {
		return reservado;
	}

	public void setReservado(String reservado) {
		this.reservado = reservado;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}
	
	@Override
	public String toString() {
		return "CLPerson [cod_error=" + cod_error + ", error=" + error + ", dni=" + dni + ", digito=" + digito
				+ ", apellido_paterno=" + apellido_paterno + ", apellido_casada=" + apellido_casada
				+ ", apellido_materno=" + apellido_materno + ", nombres=" + nombres + ", cod_continente_domicilio="
				+ cod_continente_domicilio + ", cod_pais_domicilio=" + cod_pais_domicilio
				+ ", cod_departamento_domicilio=" + cod_departamento_domicilio + ", cod_provincia_domicilio="
				+ cod_provincia_domicilio + ", cod_distrito_domicilio=" + cod_distrito_domicilio
				+ ", continente_domicilio=" + continente_domicilio + ", pais_domicilio=" + pais_domicilio
				+ ", departamento_domicilio=" + departamento_domicilio + ", provincia_domicilio=" + provincia_domicilio
				+ ", distrito_domicilio=" + distrito_domicilio + ", cod_estado_civil=" + cod_estado_civil
				+ ", estado_civil=" + estado_civil + ", cod_grado_instruccion=" + cod_grado_instruccion
				+ ", grado_instruccion=" + grado_instruccion + ", estatura=" + estatura + ", cod_sexo=" + cod_sexo
				+ ", sexo=" + sexo + ", cod_continente_nacimiento=" + cod_continente_nacimiento
				+ ", cod_pais_nacimiento=" + cod_pais_nacimiento + ", cod_departamento_nacimiento="
				+ cod_departamento_nacimiento + ", cod_provincia_nacimiento=" + cod_provincia_nacimiento
				+ ", cod_distrito_nacimiento=" + cod_distrito_nacimiento + ", continente_nacimiento="
				+ continente_nacimiento + ", pais_nacimiento=" + pais_nacimiento + ", departamento_nacimiento="
				+ departamento_nacimiento + ", provincia_nacimiento=" + provincia_nacimiento + ", distrito_nacimiento="
				+ distrito_nacimiento + ", fecha_nacimiento=" + fecha_nacimiento + ", nombre_padre=" + nombre_padre
				+ ", nombre_madre=" + nombre_madre + ", fecha_inscripcion=" + fecha_inscripcion + ", fecha_emision="
				+ fecha_emision + ", cod_constancia_votacion=" + cod_constancia_votacion + ", constancia_votacion="
				+ constancia_votacion + ", cod_restriccion=" + cod_restriccion + ", restriccion=" + restriccion
				+ ", cod_direccion=" + cod_direccion + ", direccion=" + direccion + ", nombre_direccion="
				+ nombre_direccion + ", numero_direccion=" + numero_direccion + ", block_chalet=" + block_chalet
				+ ", interior=" + interior + ", nombre_urbanizacion=" + nombre_urbanizacion + ", etapa=" + etapa
				+ ", manzana=" + manzana + ", lote=" + lote + ", cod_block=" + cod_block + ", block=" + block
				+ ", cod_departamento=" + cod_departamento + ", departamento=" + departamento + ", cod_urbanizacion="
				+ cod_urbanizacion + ", urbanizacion=" + urbanizacion + ", domicilio=" + domicilio + ", reservado="
				+ reservado + ", foto=" + foto + ", firma=" + firma + "]";
	}


}
