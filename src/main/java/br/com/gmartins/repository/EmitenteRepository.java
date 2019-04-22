package br.com.gmartins.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gmartins.model.Emitente;

@Repository
public interface EmitenteRepository extends JpaRepository<Emitente, Long> {

	
}



