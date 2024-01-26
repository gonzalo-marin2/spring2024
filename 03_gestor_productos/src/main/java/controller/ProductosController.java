package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Producto;
import service.interfaces.ProductosService;

@Controller
public class ProductosController {
	@Autowired
	ProductosService productosService;
	
	@PostMapping(value="alta")
	public String alta(@ModelAttribute Producto producto) {
		productosService.agregarProducto(producto);
		return "menu";
	}
	
	@GetMapping(value="buscar")
	public String buscar(@RequestParam("categoria") String categoria, Model model) {
		model.addAttribute("productos", productosService.buscarPorCategoria(categoria));
		return "resultadoscategorias";
	}
	
	@PostMapping(value="eliminar")
	public String eliminar(@RequestParam("nombre") String nombre) {
		productosService.eliminarProducto(nombre);
		return "menu";
	}
}
