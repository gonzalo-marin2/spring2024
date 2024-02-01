package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import service.dtos.ClienteDto;
import service.dtos.LibroDto;
import service.interfaces.ClientesService;
import service.interfaces.LibrosService;

@Controller
public class LibreriaController {
	@Autowired
	ClientesService clientesService;
	@Autowired
	LibrosService librosService;
	
	@PostMapping(value="alta")
	public String altaCliente(ClienteDto cliente, Model model) {
		if(!clientesService.altaCliente(cliente)) {
			model.addAttribute("mensaje","Usuario repetido, no se pudo registrar");
			return "registro";
		}
		return "login";
	}
	
	@GetMapping(value="login")
	public String login(@RequestParam("usuario") String usuario,@RequestParam("password") String password,Model model ) {
		if(clientesService.autenticarUsuario(usuario,password)==null) {
			model.addAttribute("mensaje", "Usuario no existente, regístrese");
			return "login";
		}
		model.addAttribute("temas", librosService.getTemas());
		return "visor";
	}
	
	@GetMapping(value="libros",produces="application/json")
	public @ResponseBody List<LibroDto> librosTema(@RequestParam("idTema") int idTema){
		return librosService.librosTema(idTema);
	}
	
	@GetMapping(value="agregarCarrito",produces="application/json")
	public @ResponseBody List<LibroDto> agregarCarrito(@RequestParam("isbn") int isbn, HttpSession sesion){
		LibroDto libro=librosService.getLibro(isbn);
		List<LibroDto> carrito=new ArrayList<>();
		if(sesion.getAttribute("carrito")!=null){
			carrito=(List<LibroDto>)sesion.getAttribute("carrito");
		}
		carrito.add(libro);
		sesion.setAttribute("carrito", carrito);
		return carrito;
	}
	
	@GetMapping(value="quitarCarrito",produces="application/json")
	public @ResponseBody List<LibroDto> quitarCarrito(@RequestParam("pos") int pos, HttpSession sesion){
		List<LibroDto> carrito=new ArrayList<>();
		if(sesion.getAttribute("carrito")!=null) {
			carrito=(List<LibroDto>)sesion.getAttribute("carrito");
			carrito.remove(pos);
		}
		sesion.setAttribute("carrito", carrito);
		return carrito;
	}
	
}
