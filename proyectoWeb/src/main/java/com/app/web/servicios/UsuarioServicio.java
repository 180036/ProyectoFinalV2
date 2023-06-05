package com.app.web.servicios;

import java.util.List;

import com.app.web.dto.UsuarioRegistroDTO;
import com.app.web.entidad.ObjetoSkinArma;
import com.app.web.entidad.Usuario;

public interface UsuarioServicio {

	public Usuario guardarUsuario(Usuario usuario);
	public Usuario obtenerUsuarioPorId(Long id);
	public Usuario actualizarUsuario(Usuario usuario);
	public 	List<ObjetoSkinArma> getInventario(Long id);
	public void eliminarUsuario(Long id);
	
	public Usuario guardarUsuarioDTO(UsuarioRegistroDTO dto);

	
}
