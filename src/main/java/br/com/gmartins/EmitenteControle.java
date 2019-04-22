package br.com.gmartins;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gmartins.model.Emitente;
import br.com.gmartins.repository.EmitenteRepository;

@RestController
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
	}
}