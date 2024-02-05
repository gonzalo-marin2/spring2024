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
import service.interfaces.VentasService;

@Controller
public class LibreriaController {
	@Autowired
	ClientesService clientesService;
	@Autowired
	LibrosService librosService;
	@Autowired
	VentasService ventasService;
	
	@PostMapping(value="alta")
	public String altaCliente(ClienteDto cliente, Model model) {
		if(!clientesService.altaCliente(cliente)) {
			model.addAttribute("mensaje","Usuario repetido, no se pudo registrar");
			return "registro";
		}
		return "menu";
	}
	
	@GetMapping(value="login")
	public String login(@RequestParam("usuario") String usuario,@RequestParam("password") String password,Model model, HttpSession sesion ) {
		ClienteDto dto=clientesService.autenticarUsuario(usuario, password);
		if(dto==null) {
			model.addAttribute("mensaje", "Usuario no existente, registrese");
			return "login";
		}
		//guardamos el cliente completo en un atributo de sesión
		sesion.setAttribute("cliente", dto);
		return "menu";
	}
	
	@GetMapping(value="libros",produces="application/json")
	public @ResponseBody List<LibroDto> librosTema(@RequestParam("idTema") int idTema){
		return librosService.librosTema(idTema);
	}
	
	@GetMapping(value="consulta")
	public String consulta( Model model) {
		model.addAttribute("temas", librosService.getTemas());
		return "visor";
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
	
	@GetMapping(value="ventas",produces="application/json")
	public String venta(HttpSession sesion, Model model) {
		ClienteDto dto=(ClienteDto)sesion.getAttribute("cliente");
		model.addAttribute("ventas", ventasService.informeVentasCliente(dto.getUsuario()));
		return "ventas";
	}
	
	@GetMapping(value="comprar")
	public String comprar(HttpSession sesion) {
		ClienteDto cliente=(ClienteDto)sesion.getAttribute("cliente");
		List<LibroDto> libros=(List<LibroDto>)sesion.getAttribute("carrito");
		ventasService.registrarCompra(cliente.getUsuario(), libros);
		//forzamos fin de sesión
		sesion.invalidate();
		return "login";
	}
	
}
