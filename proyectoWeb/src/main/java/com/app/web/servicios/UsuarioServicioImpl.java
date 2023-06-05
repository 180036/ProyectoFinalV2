package com.app.web.servicios;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.dto.UsuarioRegistroDTO;
import com.app.web.entidad.ObjetoSkinArma;
import com.app.web.entidad.Rol;
import com.app.web.entidad.Usuario;
import com.app.web.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

	@Autowired
	private UsuarioRepositorio repositorio;

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorio.save(usuario);
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorio.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<ObjetoSkinArma> getInventario(Long id) {
		// TODO Auto-generated method stub
		Usuario u = obtenerUsuarioPorId(id);
		return u.getListaObjetoSkinArmas();
	}

	@Override
	public Usuario guardarUsuarioDTO(UsuarioRegistroDTO dto) {
		Usuario u = new Usuario(dto.getNombre(), dto.getContrasena(), dto.getEmail(), Arrays.asList(new Rol("ROLE_USER")));
		return repositorio.save(u);
	}

}
