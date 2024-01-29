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
	
	@PostMapping(value="agregar")
	public String agregar(@ModelAttribute Producto producto) {
		productosService.agregarProducto(producto);
		return "menu";
	}
	
	@GetMapping(value="buscar")
	public String buscar(@RequestParam("categoria") String categoria, Model model) {
		model.addAttribute("productos", productosService.buscarPorCategoria(categoria));
		return "productos";
	}
	
	@GetMapping(value="eliminar")
	public String eliminar(@RequestParam("nombre") String nombre, Model model) {
		Producto prod=productosService.eliminarProducto(nombre);
		if(prod!=null) {
			model.addAttribute("mensajeEliminar", "se ha eliminado el producto "+nombre+" de la base de datos");
		}else {
			model.addAttribute("mensajeEliminar", "el producto "+nombre+" no existe");
		}
		return "menu";	
	}
	
	@GetMapping(value="actualizar")
	public String actualizar(@RequestParam("nombre") String nombre, @RequestParam("nuevoPrecio") double nuevoPrecio, Model model) {
		productosService.modificarPrecio(nombre, nuevoPrecio);
		return "menu";
	}
}
