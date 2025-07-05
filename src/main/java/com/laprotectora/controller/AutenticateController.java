package com.laprotectora.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laprotectora.config.JwtTokenUtil;
import com.laprotectora.dto.CLResponse;
import com.laprotectora.dto.JwtRequest;
import com.laprotectora.dto.JwtResponse;
import com.laprotectora.dto.UsuarioDto;
import com.laprotectora.service.UsuarioService;

@RestController
@CrossOrigin()
public class AutenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UsuarioService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest){
		String mensaje = "";
		try {
			mensaje = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			
			if(mensaje.equalsIgnoreCase("ok")) {
				final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
				final String token = jwtTokenUtil.generateToken(userDetails);
				return ResponseEntity.ok(new JwtResponse(token));
			}
			else {
				CLResponse respuesta = new CLResponse();
				respuesta.setCodigo(400);
				respuesta.setStatus(false);			
				respuesta.setMensaje(mensaje);
				return ResponseEntity.ok(respuesta);
			}
		}
		catch(Exception e) {
			CLResponse respuesta = new CLResponse();
			respuesta.setCodigo(400);
			respuesta.setStatus(false);
			respuesta.setMensaje("Usuario no encontrado");
			return ResponseEntity.ok(respuesta);
		}

	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UsuarioDto user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	private String authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			return "ok";
		} catch (DisabledException e) {
			//throw new Exception("USUARIO DESHABILITADO", e);
			return "Usuario deshabilitado";
		} catch (BadCredentialsException e) {
			//throw new Exception("CREDENCIALES INVALIDAS", e);
			return "Credenciales invalidas";
		}
	}
	
}
