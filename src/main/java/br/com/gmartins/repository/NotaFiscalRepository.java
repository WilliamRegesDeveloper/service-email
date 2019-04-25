package br.com.gmartins.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gmartins.model.NotaFiscal;

@Transactional
@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Integer> {

	@Query(value = "SELECT * FROM NOTAFISCAL u WHERE u.CHAVE_NFE = ?1", nativeQuery = true)
	
	NotaFiscal findByChaveDeAcesso(String chaveNfe);

}



