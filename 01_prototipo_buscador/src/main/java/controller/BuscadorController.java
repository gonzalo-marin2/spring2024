package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Resultado;
import service.interfaces.BuscadorService;

@Controller
public class BuscadorController {
	@Autowired
	BuscadorService buscadorService;
	@GetMapping(value="buscar")
	public String buscar(@RequestParam("tematica") String tematica, Model model) {
		List<Resultado> resultados=buscadorService.buscar(tematica);
		model.addAttribute("resultados", resultados);//equivale al request.setAtribbute(...)
		return "resultados";//nombre de la página
	}
	
	@PostMapping(value="alta")
	public String alta(@ModelAttribute Resultado resultado) {
		buscadorService.agregar(resultado);
		return "menu";
	}
	
	//para volver a la página de búsqueda desde la página resultados
		@GetMapping(value="toBuscar")
		public String toBuscar() {
			return "buscar";
		}
	
	//navegación estática
	@GetMapping(value="toAlta")
	public String toAlta() {
		return "alta";
	}
	//página de inicio
	@GetMapping(value={"toMenu","/"})
	public String bienvenida() {
		return "menu";
	}
	
	
}
