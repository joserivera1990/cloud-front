package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.viagging.core.model.Usuario;
import com.viagging.rest.dto.UsuarioDTO;

@Component
public class UsuarioDTOMapper {
	
	public UsuarioDTO mapObject(Usuario usuario){
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.getId().toString());
		usuarioDTO.setPrimerNombre(usuario.getPrimerNombre());
		usuarioDTO.setSegundoNombre(usuario.getSegundoNombre());
		usuarioDTO.setPrimerApellido(usuario.getPrimerApellido());
		usuarioDTO.setSegundoApellido(usuario.getSegundoApellido());
		usuarioDTO.setCorreo(usuario.getCorreo());
		usuarioDTO.setNumeroDocumento(usuario.getNumeroDocumento());
		usuarioDTO.setFacebookId(usuario.getFacebookId());
		usuarioDTO.setTwitterId(usuario.getTwitterId());
		
		return usuarioDTO;
	}
	
	public List<UsuarioDTO> mapObjectList(List<Usuario> usuarios){
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		for(Usuario usuario : usuarios){
			usuariosDTO.add(mapObject(usuario));
		}
		return usuariosDTO;
	}

}
