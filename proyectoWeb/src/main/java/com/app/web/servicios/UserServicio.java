package com.app.web.servicios;

import java.util.List;

import com.app.web.usuarioregistro.User;

public interface UserServicio {
	
	public List<User> listarTodosUsuarios();
	public User guardarUsuario(User usuario);
	public User obtenerUsuarioPorId(Long id);
	public User actualizarUsuario(User usuario);
	public void eliminarUsuario(Long id);
	public User obtenerUsuarioPorNombre(String nombre);
	public User obtenerUsuarioPorEmail(String email);
}
