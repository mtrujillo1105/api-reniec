package com.laprotectora.controller;

import java.util.Base64;
import java.util.Collections;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.laprotectora.entity.Canal;
import com.laprotectora.entity.Empresa;
import com.laprotectora.entity.Usuario;
import com.laprotectora.repository.IUsuarioRepository;
import com.laprotectora.service.CanalService;
import com.laprotectora.service.EmpresaService;
import com.laprotectora.dto.CLRequest;
import com.laprotectora.dto.CLResponse;

@RestController
@RequestMapping("/dni")
public class RequestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmpresaService empresaService;	
	
	@Autowired
	private CanalService canalService;	
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
    @Value("${project.datacenter.server}")
    private String DC_SERVER_OTRO;
	
	//Search a person by DNI
	@PostMapping("/valida")
	public ResponseEntity<CLResponse> consultaDni(@RequestBody CLRequest peticion,@RequestHeader("Authorization") String token) {
		CLResponse respuesta = new CLResponse();
		
		try {

			//Validated exist parameters and token
			if(token.equalsIgnoreCase("")) {
				respuesta.setCodigo(500);
				respuesta.setStatus(false);
				respuesta.setMensaje("Debe introducir un token");
				return new ResponseEntity<CLResponse>(respuesta,HttpStatus.OK);	
			}
			if(peticion.getEmpresa() == null || peticion.getEmpresa().equalsIgnoreCase("")) {
				respuesta.setCodigo(400);
				respuesta.setStatus(false);
				respuesta.setMensaje("Debe ingresar una empresa");
				return new ResponseEntity<CLResponse>(respuesta,HttpStatus.OK);	
			}
			if(peticion.getCanal() == null || peticion.getCanal().equalsIgnoreCase("")) {
				respuesta.setCodigo(400);
				respuesta.setStatus(false);
				respuesta.setMensaje("Debe ingresar un canal");
				return new ResponseEntity<CLResponse>(respuesta,HttpStatus.OK);	
			}
			if(peticion.getDni() == null || peticion.getDni().equalsIgnoreCase("")) {
				respuesta.setCodigo(400);
				respuesta.setStatus(false);
				respuesta.setMensaje("Debe ingresar un DNI");
				return new ResponseEntity<CLResponse>(respuesta,HttpStatus.OK);	
			}						
			if(peticion.getTipo_consulta() == null || peticion.getTipo_consulta().equalsIgnoreCase("")) 	
				peticion.setTipo_consulta("1");//Simple Consult
			if(peticion.getFoto_firma() == null || peticion.getFoto_firma().equalsIgnoreCase("")) 		
				peticion.setFoto_firma("0");//No image
			
			//Validate data
			if(valida_empresa(peticion) != null) {
				CLResponse respuestaEmpresa = valida_empresa(peticion); 
				return new ResponseEntity<CLResponse>(respuestaEmpresa,HttpStatus.OK);	
			}
			if(valida_canal(peticion) != null) {
				CLResponse respuestaCanal = valida_canal(peticion); 
				return new ResponseEntity<CLResponse>(respuestaCanal,HttpStatus.OK);
			}
			if(valida_dni(peticion) != null) {
				CLResponse respuestaDni = valida_dni(peticion); 
				return new ResponseEntity<CLResponse>(respuestaDni,HttpStatus.OK);	
			}
			if(valida_tipo_consulta(peticion) != null) {
				CLResponse respuestaTipoConsulta = valida_tipo_consulta(peticion); 
				return new ResponseEntity<CLResponse>(respuestaTipoConsulta,HttpStatus.OK);
			}
			if(valida_foto_firma(peticion) != null) {
				CLResponse respuestaFotoFirma = valida_foto_firma(peticion); 
				return new ResponseEntity<CLResponse>(respuestaFotoFirma,HttpStatus.OK);
			}
			if(valida_token(token,peticion) != null) {
				CLResponse respuestaToken = valida_token(token,peticion); 
				return new ResponseEntity<CLResponse>(respuestaToken,HttpStatus.OK);
			}

			//Complete parameters
			int empresaId = Integer.parseInt(peticion.getEmpresa());
			Optional<Empresa> empresa = empresaService.getEmpresaById(empresaId);
			peticion.setCodigo_reniec(empresa.get().getCodigo_reniec());
			peticion.setServidor(empresa.get().getServidor());
			
			//Send request DC Server
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.set("Authorization", token);
			HttpEntity<CLRequest> entity = new HttpEntity<>(peticion, headers);
			return  restTemplate.postForEntity(DC_SERVER_OTRO,entity,CLResponse.class);

		}
		catch(Exception e){
			respuesta.setCodigo(400);
			respuesta.setStatus(false);
			respuesta.setMensaje("Error no determinado");
			return new ResponseEntity<CLResponse>(respuesta,HttpStatus.OK);	
		}
	}
	
	//Valid the company
	private CLResponse valida_empresa(CLRequest peticion) {
		CLResponse respuesta = new CLResponse();
		try {
			
			int empresaId = Integer.parseInt(peticion.getEmpresa());
			Optional<Empresa> empresa = empresaService.getEmpresaById(empresaId);
			
			//Exist company
			if(!empresa.isPresent()) {
				respuesta.setCodigo(400);
				respuesta.setStatus(false);
				respuesta.setMensaje("Empresa no encontrada");
				return respuesta;
			}
			else {
				String estado = empresa.get().getEstado();
				
				//Active company
				if(estado.equalsIgnoreCase("0")) {
					respuesta.setCodigo(400);
					respuesta.setStatus(false);
					respuesta.setMensaje("La empresa se encuentra inactiva");
					return respuesta;
				}
			}
			
		}
		catch(NumberFormatException nfe) {
			respuesta.setCodigo(400);
			respuesta.setStatus(false);
			respuesta.setMensaje("Se esperaba un numero y envio una cadena");
			return respuesta;	
		}
		return null;
	}
	
	//Valid channel
	private CLResponse valida_canal(CLRequest peticion) {
		CLResponse respuesta = new CLResponse();
		
		try {
			int empresaId = Integer.parseInt(peticion.getEmpresa());
			int canalId   = Integer.parseInt(peticion.getCanal());
			Optional<Canal> canal = canalService.getCanalById(canalId);
			
			//Exist channel
			if(!canal.isPresent()) {
				respuesta.setCodigo(200);
				respuesta.setStatus(false);
				respuesta.setMensaje("Canal no encontrado");
				return respuesta;
			}
			else {
				String estado = canal.get().getEstado();
				int empresaCanal = Integer.parseInt(canal.get().getEmpresa());
				
				//Active channel
				if(estado.equalsIgnoreCase("0")) {
					respuesta.setCodigo(400);
					respuesta.setStatus(false);
					respuesta.setMensaje(String.valueOf("El canal se encuentra inactivo"));
					return respuesta;
				}

				//Channel belongs to the company
				if(empresaCanal != empresaId){
					respuesta.setCodigo(400);
					respuesta.setStatus(false);
					respuesta.setMensaje(String.valueOf("El canal no pertenece a la empresa"));
					return respuesta;
				}		

			}
		}
		catch(NumberFormatException nfe) {
			respuesta.setCodigo(400);
			respuesta.setStatus(false);
			respuesta.setMensaje("Se esperaba un numero y envio una cadena");
			return respuesta;
		}
		return null;

	}
	
	//Valid DNI
	public CLResponse valida_dni(CLRequest peticion) {
		CLResponse respuesta = new CLResponse();
		String dni = peticion.getDni();
		
		//Is numeric
		if(dni.matches("[+-]?\\d*(\\.\\d+)?")) {
			
			if(dni.length() > 8 || dni.length() < 8 ) {
				respuesta.setCodigo(400);
				respuesta.setStatus(false);
				respuesta.setMensaje("El DNI no tiene la cantidad de dígitos requerida");
				return respuesta;		
			}
			
		}
		else {
			respuesta.setCodigo(400);
			respuesta.setStatus(false);
			respuesta.setMensaje("El DNI solo debe tener números");
			return respuesta;	
		}
		
		return null;
		
	}
	
	//Valid tipo de consulta
	public CLResponse valida_tipo_consulta(CLRequest peticion) {
		CLResponse respuesta = new CLResponse();
		String tipo_consulta = peticion.getTipo_consulta();
		
		//Is numeric
		if(tipo_consulta.matches("[+-]?\\d*(\\.\\d+)?")) {
			
			if(!tipo_consulta.equalsIgnoreCase("1") && !tipo_consulta.equalsIgnoreCase("2")) {
				respuesta.setCodigo(400);
				respuesta.setStatus(false);
				respuesta.setMensaje("El tipo de consulta solo puede ser 1 o 2");
				return respuesta;	
			}
			
		}
		else {
			respuesta.setCodigo(400);
			respuesta.setStatus(false);
			respuesta.setMensaje("El tipo de consulta solo permite números");
			return respuesta;	
		}
		
		return null;
	}
	
	//Valid foto_firma
	public CLResponse valida_foto_firma(CLRequest peticion) {
		CLResponse respuesta = new CLResponse();
		String foto_firma = peticion.getFoto_firma();
		
		//Is numeric
		if(foto_firma.matches("[+-]?\\d*(\\.\\d+)?")) {
			
			if(!foto_firma.equalsIgnoreCase("0") && !foto_firma.equalsIgnoreCase("1")) {
				respuesta.setCodigo(400);
				respuesta.setStatus(false);
				respuesta.setMensaje("El campo foto_firma solo puede ser 0 o 1");
				return respuesta;	
			}
			
		}
		else {
			respuesta.setCodigo(400);
			respuesta.setStatus(false);
			respuesta.setMensaje("El campo foto_firma solo permite números");
			return respuesta;	
		}
		
		return null;
	}
	
	private CLResponse valida_token(String token,CLRequest peticion) {
		
		CLResponse respuesta = new CLResponse();
		
		if(!token.equalsIgnoreCase("")) {
			String[] chunks    = token.split("\\.");
			Base64.Decoder decoder = Base64.getDecoder();
			String payload     = new String(decoder.decode(chunks[1]));
			JSONObject json    = new JSONObject(payload);
			String user     = json.getString("sub");
			
			//Se obtiene el canal del usuario
			Usuario usuario = usuarioRepository.findByUsername(user);
			if(!peticion.getCanal().trim().equalsIgnoreCase(usuario.getCanal())) {
				respuesta.setCodigo(400);
				respuesta.setStatus(false);
				respuesta.setMensaje("El usuario no pertenece al canal consultante");
				return respuesta;	
			}
			return null;
			
		}
		return null;
		
	}

}
