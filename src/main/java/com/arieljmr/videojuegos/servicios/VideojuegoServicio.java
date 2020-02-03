package com.arieljmr.videojuegos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arieljmr.videojuegos.entidades.Videojuego;
import com.arieljmr.videojuegos.repositorios.VideojuegoRepositorio;
import java.util.List;

@Service
public class VideojuegoServicio 
{
	@Autowired
	private VideojuegoRepositorio videojuegoRepositorio;
	
	public List<Videojuego> BuscarDestacados()
	{
		return videojuegoRepositorio.BuscarTodos();
	}
	public List<Videojuego> BuscarPorDistribuidor(int distribuidorId)
	{
		return videojuegoRepositorio.BuscarPorDistribuidor(distribuidorId);
	}
	public List<Videojuego> Buscar(String consulta)
	{
		return videojuegoRepositorio.findByNombreContaining(consulta);
	}
}
