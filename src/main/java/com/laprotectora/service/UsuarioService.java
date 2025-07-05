package com.laprotectora.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.laprotectora.dto.UsuarioDto;
import com.laprotectora.entity.Usuario;
import com.laprotectora.repository.IUsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;	
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			Usuario user = usuarioRepository.findByUsername(username);
			return new User(user.getUsername(), user.getPassword(),new ArrayList<>());		
		}
		catch(UsernameNotFoundException ew) {
			throw new UsernameNotFoundException("Usuario no encontrado con el username: " + username);
		}
	}
	
	public Usuario save(UsuarioDto usuario) {
		Usuario newUser = new Usuario();
		newUser.setUsername(usuario.getUsername());
		newUser.setPassword(bcryptEncoder.encode(usuario.getPassword()));
		newUser.setCanal(usuario.getCanal());
		return usuarioRepository.save(newUser);
	}
}
