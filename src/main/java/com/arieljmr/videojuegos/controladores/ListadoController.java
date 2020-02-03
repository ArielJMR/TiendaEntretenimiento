package com.arieljmr.videojuegos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arieljmr.videojuegos.entidades.Videojuego;
import com.arieljmr.videojuegos.servicios.VideojuegoServicio;

@Controller
public class ListadoController {
	
	@Autowired
	private VideojuegoServicio videojuegoServicio;
	
	@RequestMapping("/")
	public String listarVideojuegos(Model model)
	{
		List<Videojuego> destacados = videojuegoServicio.BuscarDestacados();
		model.addAttribute("videojuegos", destacados);
		return "listado";
	}
	@RequestMapping("/VideojuegosPorDistribuidor")
	public String listarVideojuegosPorDistribuidor(int distribuidorId,Model model) 
	{
		List<Videojuego> juegos = videojuegoServicio.BuscarPorDistribuidor(distribuidorId);
		model.addAttribute("videojuegos",juegos);
		return "listado";
	}
	@RequestMapping("/Buscar")
	public String buscar(@RequestParam("q")String consulta,Model model)
	{
		List<Videojuego> juego = videojuegoServicio.Buscar(consulta);
		model.addAttribute("videojuegos", juego);
		return "listado";
	}
}
