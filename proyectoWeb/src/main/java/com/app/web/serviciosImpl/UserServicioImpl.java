package com.app.web.serviciosImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.repositorios.UserRepository;
import com.app.web.servicios.UserServicio;
import com.app.web.usuarioregistro.User;

@Service
public class UserServicioImpl implements UserServicio{

	@Autowired
	private UserRepository repo;
	
	@Override
	public List<User> listarTodosUsuarios() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User guardarUsuario(User usuario) {
		// TODO Auto-generated method stub
		return repo.save(usuario);
	}

	@Override
	public User obtenerUsuarioPorId(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public User actualizarUsuario(User usuario) {
		// TODO Auto-generated method stub
		return repo.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}
	
	@Override
	public User obtenerUsuarioPorNombre(String nombre) {
		List<User> lista = listarTodosUsuarios(); 
		for(User s: lista) {
			if(s.getName().equalsIgnoreCase(nombre)) {
				return s;
			}
		}
		return null;
	}

}
