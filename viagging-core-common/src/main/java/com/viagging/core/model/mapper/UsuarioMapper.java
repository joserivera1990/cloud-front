package com.viagging.core.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.viagging.core.model.Usuario;
import com.viagging.rest.dto.UsuarioDTO;

@Component
public class UsuarioMapper {

	public Usuario mapObject(UsuarioDTO usuarioDTO){
		Usuario usuario = new Usuario();
		if(!StringUtils.isEmpty(usuarioDTO.getId())){
			usuario.setId(Integer.valueOf(usuarioDTO.getId()));
		}
		usuario.setPrimerNombre(usuarioDTO.getPrimerNombre());
		usuario.setCorreo(usuarioDTO.getCorreo());
		usuario.setPrimerApellido(usuarioDTO.getPrimerApellido());
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setPassword(usuarioDTO.getPassword());
		usuario.setFacebookId(usuarioDTO.getFacebookId());
		usuario.setTwitterId(usuarioDTO.getTwitterId());
		return usuario;
	}
	
	public List<Usuario> mapObjectList(List<UsuarioDTO> usuariosDTO){
		List<Usuario> usuarios = new ArrayList<>();
		for(UsuarioDTO usuarioDTO : usuariosDTO)
			usuarios.add(mapObject(usuarioDTO));
		return usuarios;
		
	}
	
	public void updateObject(Usuario usuario, Usuario newUsuario){
		if(StringUtils.isNotEmpty(newUsuario.getPrimerNombre())){
			usuario.setPrimerNombre(newUsuario.getPrimerNombre());
		}
		if(StringUtils.isNotEmpty(newUsuario.getSegundoNombre())){
			usuario.setSegundoNombre(newUsuario.getSegundoNombre());
		}
		if(StringUtils.isNotEmpty(newUsuario.getPrimerApellido())){
			usuario.setPrimerApellido(newUsuario.getPrimerApellido());
		}
		if(StringUtils.isNotEmpty(newUsuario.getSegundoApellido())){
			usuario.setSegundoApellido(newUsuario.getSegundoApellido());
		}
		if(StringUtils.isNotEmpty(newUsuario.getCorreo())){
			usuario.setCorreo(newUsuario.getCorreo());
		}
		if(StringUtils.isNotEmpty(newUsuario.getNumeroCelular())){
			usuario.setNumeroCelular(newUsuario.getNumeroCelular());
		}
		if(StringUtils.isNotEmpty(newUsuario.getDireccion1())){
			usuario.setDireccion1(newUsuario.getDireccion1());
		}
		if(StringUtils.isNotEmpty(newUsuario.getDireccion2())){
			usuario.setDireccion2(newUsuario.getDireccion2());
		}
		if(StringUtils.isNotEmpty(newUsuario.getCiudad())){
			usuario.setCiudad(newUsuario.getCiudad());
		}
		if(StringUtils.isNotEmpty(newUsuario.getPais())){
			usuario.setPais(newUsuario.getPais());
		}
		if(StringUtils.isNotEmpty(newUsuario.getEstado())){
			usuario.setEstado(newUsuario.getEstado());
		}
		if(StringUtils.isNotEmpty(newUsuario.getZipcode())){
			usuario.setZipcode(newUsuario.getZipcode());
		}
	}
		
}
