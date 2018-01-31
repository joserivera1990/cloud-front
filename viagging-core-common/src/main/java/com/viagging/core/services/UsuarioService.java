package com.viagging.core.services;

import com.viagging.core.model.Usuario;
import com.viagging.rest.dto.UsuarioDTO;

public interface UsuarioService {
     
	Usuario findUsuarioByLoginAndPassword(String login, String password);
	
	Usuario findUsuarioByLogin(String login);
	
	Usuario getUsuarioById(Integer idUsuario);
	
	Usuario findUsuarioByEmailOrSocialNetwork(String email, String facebookId, String twitterId);

	Usuario createUsuario(Usuario usuario,String idPerfil)throws Exception;

	Usuario updateUsuario(Usuario usuario);
	
	Usuario buildUsuario(UsuarioDTO usuarioDTO);
	
	Usuario findUsuarioByNumber(String numeroDocumento);
	
	void deleteUser(Integer idUser);
	
}