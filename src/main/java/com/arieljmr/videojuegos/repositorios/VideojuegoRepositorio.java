package com.arieljmr.videojuegos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arieljmr.videojuegos.entidades.Videojuego;

public interface VideojuegoRepositorio extends JpaRepository<Videojuego, Integer>
{
	@Query("from Videojuego v order by v.nombre")
	List<Videojuego> BuscarTodos();
	
	@Query("from Videojuego v where v.distribuidor.id = ?1 order by v.nombre")/*/-?1- hace referencia al primer parametro que pasamos en el metodo buscar por distribuidor/*/
	List<Videojuego> BuscarPorDistribuidor(int distribuidorId);
	
	List<Videojuego> findByNombreContaining(String consulta);
	
}
