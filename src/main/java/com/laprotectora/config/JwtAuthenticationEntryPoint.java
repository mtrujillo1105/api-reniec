package com.laprotectora.config;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.laprotectora.dto.CLResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		//Mensaje de respuesta
		CLResponse respuesta = new CLResponse();
		respuesta.setCodigo(400);
		respuesta.setStatus(false);			
		respuesta.setMensaje("Token invalido");
		String respuestaString = new Gson().toJson(respuesta);
		
		response.reset();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(respuestaString);
		response.getWriter().flush();
		
		//response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Desautorizado");
	}
}
