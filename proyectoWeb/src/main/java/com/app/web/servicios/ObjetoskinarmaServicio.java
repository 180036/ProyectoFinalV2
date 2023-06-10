package com.app.web.servicios;

import java.util.List;

import com.app.web.entidad.Caja;
import com.app.web.entidad.ObjetoSkinArma;

/**
 * Interfaz que define los métodos para operar con la entidad ObjetoSkinArma en el sistema.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
public interface ObjetoskinarmaServicio {
	
	/**
     * Retorna una lista de todos los objetos de skin de arma en el sistema.
     *
     * @return Una lista de objetos ObjetoSkinArma.
     */
    public List<ObjetoSkinArma> listarOSA();

    /**
     * Guarda un objeto de skin de arma en el sistema.
     *
     * @param osa El objeto de skin de arma a guardar.
     * @return El objeto de skin de arma guardado.
     */
    public ObjetoSkinArma guardarOSA(ObjetoSkinArma osa);

    /**
     * Obtiene un objeto de skin de arma por su ID.
     *
     * @param id El ID del objeto de skin de arma.
     * @return El objeto de skin de arma encontrado, o null si no se encuentra ningún objeto con ese ID.
     */
    public ObjetoSkinArma obtenerOSAPorId(Long id);

    /**
     * Actualiza un objeto de skin de arma en el sistema.
     *
     * @param osa El objeto de skin de arma a actualizar.
     * @return El objeto de skin de arma actualizado.
     */
    public ObjetoSkinArma actualizarOSA(ObjetoSkinArma osa);

    /**
     * Elimina un objeto de skin de arma del sistema.
     *
     * @param id El ID del objeto de skin de arma a eliminar.
     */
    public void eliminarOSA(Long id);

}
