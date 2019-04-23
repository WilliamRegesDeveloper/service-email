package br.com.gmartins.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gmartins.model.NotaFiscalDetalhe;

@Transactional
@Repository
public interface NotaFiscalDetalheRepository extends JpaRepository<NotaFiscalDetalhe, Integer> {

	
}



