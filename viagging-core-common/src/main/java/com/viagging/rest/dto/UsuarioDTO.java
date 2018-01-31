package com.viagging.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.viagging.core.model.CuentaAcceso;
import com.viagging.core.model.Usuario;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {
	
	private String id;
    
	private String login;

	private String password;
	
	private String correo;
	
	@JsonInclude(Include.NON_NULL)
	private String numeroCelular;
	
	@JsonInclude(Include.NON_NULL)
	private String numeroDocumento;
    
	@JsonInclude(Include.NON_NULL)
	private String primerApellido;
    
	@JsonInclude(Include.NON_NULL)
	private String primerNombre;

	private String segundoApellido;

	private String segundoNombre;

	private String tipoDocumento;
	
	private String direccion1;
	
	private String direccion2;
	
	private String ciudad;
	
	private String pais;
	
	private String estado;
	
	private String zipcode;
	
	private String facebookId;
	
	private String twitterId;

    private PerfilDTO perfil;
    
    private String jwtToken;

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", login=" + login + ", password="
				+ password + ", correo=" + correo + ", numeroCelular="
				+ numeroCelular + ", numeroDocumento=" + numeroDocumento
				+ ", primerApellido=" + primerApellido + ", primerNombre="
				+ primerNombre + ", segundoApellido=" + segundoApellido
				+ ", segundoNombre=" + segundoNombre + ", tipoDocumento="
				+ tipoDocumento + ", perfil=" + perfil + "]";
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}

	/**
	 * Builds an {@link UsuarioDTO} object from an {@link Usuario} object.
	 *
	 * @param usuario the usuario
	 * @return the usuario dto
	 */
	public static UsuarioDTO buildObject(Usuario usuario){
		UsuarioDTO usuarioDto = new UsuarioDTO();
		usuarioDto.setId(String.valueOf(usuario.getId()));
		usuarioDto.setCorreo(usuario.getCorreo());
		usuarioDto.setNumeroCelular(usuario.getNumeroCelular());
		usuarioDto.setPrimerNombre(usuario.getPrimerNombre());
		usuarioDto.setSegundoNombre(usuario.getSegundoNombre());
		usuarioDto.setPrimerApellido(usuario.getPrimerApellido());
		usuarioDto.setSegundoApellido(usuario.getSegundoApellido());
		usuarioDto.setTipoDocumento(usuario.getTipoDocumento());
		usuarioDto.setNumeroDocumento(usuario.getNumeroDocumento());
		usuarioDto.setLogin(usuario.getLogin());
		usuarioDto.setDireccion1(usuario.getDireccion1());
		usuarioDto.setDireccion2(usuario.getDireccion2());
		usuarioDto.setCiudad(usuario.getCiudad());
		usuarioDto.setPais(usuario.getPais());
		usuarioDto.setEstado(usuario.getEstado());
		usuarioDto.setZipcode(usuario.getZipcode());
		usuarioDto.setPassword(usuario.getPassword());
		return usuarioDto;
	}
	
	
	public static List<UsuarioDTO> buildListObject(List<CuentaAcceso> listCuentaAcceso){
		List<UsuarioDTO> listUser = new ArrayList<>();
		for (CuentaAcceso cuentaAcceso : listCuentaAcceso) {
			UsuarioDTO usuarioDto = new UsuarioDTO();
		    usuarioDto = UsuarioDTO.buildObject(cuentaAcceso.getUsuario());
            usuarioDto.setPerfil(PerfilDTO.buildObject(cuentaAcceso.getPerfil()));
		    listUser.add(usuarioDto);
		}
		return listUser;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
}
