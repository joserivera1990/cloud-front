package com.viagging.core.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.CuentaAcceso;
import com.viagging.core.model.Perfil;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.CuentaAccesoService;
import com.viagging.core.services.PerfilService;
import com.viagging.core.services.UsuarioService;
import com.viagging.exception.LoginExistExeption;
import com.viagging.rest.dto.UsuarioDTO;

/**
 * The Class UsuarioServiceImpl.
 */
@Service
public class UsuarioServiceImpl implements  UsuarioService  {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private CuentaAccesoService cuentaAccesoService;

	/* (non-Javadoc)
	 * @see com.viagging.core.services.UsuarioService#findUsuarioByLoginAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario findUsuarioByLoginAndPassword(String login, String password){
		return usuarioDAO.findUsuarioByLoginAndPassword(login, password);
	};
	
	@Override
	public Usuario findUsuarioByLogin(String login){
		return usuarioDAO.findUsuarioByLogin(login);
	}
	
	/* (non-Javadoc)
	 * @see com.viagging.core.services.UsuarioService#getUsuarioById(java.lang.Integer)
	 */
	@Override
	public Usuario getUsuarioById(Integer idUsuario) {
		return usuarioDAO.getUsuarioById(idUsuario);
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.services.UsuarioService#createUsuario(com.viagging.core.model.Usuario)
	 */
	@Override
	public Usuario createUsuario(Usuario usuario,String idPerfil) throws Exception {
		
		try {
			    Usuario usuarioExistente = usuarioDAO.findUsuarioByLogin(usuario.getLogin());
				if(usuarioExistente == null){
				    usuario = usuarioDAO.createUsuario(usuario);
					Perfil perfil  = perfilService.getPerfilById(Integer.valueOf(idPerfil));
					CuentaAcceso cuentaAcceso = new CuentaAcceso();
					cuentaAcceso.setPerfil(perfil);
					cuentaAcceso.setUsuario(usuario);
					cuentaAccesoService.createCuentaAcceso(cuentaAcceso);
				}else{
					throw new LoginExistExeption();
				}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}		
		return usuario;
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.services.UsuarioService#updateUsuario(com.viagging.core.model.Usuario)
	 */
	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioDAO.updateUsuario(usuario);
	}
	
	@Override
	public Usuario buildUsuario(UsuarioDTO usuarioDTO){
		Usuario usuario = new Usuario();
		usuario.setId( usuarioDTO.getId() != null ? Integer.valueOf(usuarioDTO.getId()) :  null);
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setPassword(usuarioDTO.getPassword());
		usuario.setNumeroCelular(usuarioDTO.getNumeroCelular());
		usuario.setNumeroDocumento(usuarioDTO.getNumeroDocumento());
		usuario.setPrimerApellido(usuarioDTO.getPrimerApellido());
		usuario.setSegundoApellido(usuarioDTO.getSegundoApellido());
		usuario.setPrimerNombre(usuarioDTO.getPrimerNombre());
		usuario.setSegundoNombre(usuarioDTO.getSegundoNombre());
		usuario.setTipoDocumento(usuarioDTO.getTipoDocumento());
		usuario.setCorreo(usuarioDTO.getCorreo());
		usuario.setDireccion1(usuarioDTO.getDireccion1());
		usuario.setDireccion2(usuarioDTO.getDireccion2());
		usuario.setCiudad(usuarioDTO.getCiudad());
		usuario.setPais(usuarioDTO.getPais());
		usuario.setEstado(usuarioDTO.getEstado());
		usuario.setZipcode(usuarioDTO.getZipcode());
		return usuario;
	}
	
	@Override
	public Usuario findUsuarioByNumber(String numeroDocumento){
		return usuarioDAO.findUsuarioByNumber(numeroDocumento);
	}
	
	public void deleteUser(Integer idUser){
		 usuarioDAO.deleteUser(idUser);
	}

	@Override
	public Usuario findUsuarioByEmailOrSocialNetwork(String email, String facebookId, String twitterId) {
		return usuarioDAO.findUsuarioByEmailOrSocialNetwork(email, facebookId, twitterId);
	}
	
}