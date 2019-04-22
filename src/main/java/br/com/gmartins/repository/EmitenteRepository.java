package br.com.gmartins.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import br.com.gmartins.model.Emitente;

@Transactional
@Repository
public interface EmitenteRepository extends JpaRepository<Emitente, Long> {

	
}



