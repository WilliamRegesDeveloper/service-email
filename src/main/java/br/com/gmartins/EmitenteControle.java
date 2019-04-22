package br.com.gmartins;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gmartins.model.Emitente;
import br.com.gmartins.repository.EmitenteRepository;



public class EmitenteControle {
	
	@Autowired
	private EmitenteRepository emitenteRepository;
	
	@Test
    public void testRepository(){
		
		emitenteRepository.save(new Emitente("Maria Oliveira","123456789"));
		
		 final List<Emitente> todos = emitenteRepository.findAll();
		 System.out.println(todos);
/*@RestController
@RequestMapping("/")
public class EmitenteControle {
	
	@Autowired
	private EmitenteRepository emitenteRepository;
	
	@GetMapping
	public List<Emitente> listar() {
		return emitenteRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Emitente> criar(@RequestBody Emitente emitente, HttpServletResponse response) {
		Emitente emitenteSalva =  emitenteRepository.save(emitente);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(emitenteSalva.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(emitenteSalva);	
	}*/
	
	}
	
}

