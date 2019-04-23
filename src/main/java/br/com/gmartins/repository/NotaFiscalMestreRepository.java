package br.com.gmartins.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gmartins.model.NotaFiscalMestre;

@Transactional
@Repository
public interface NotaFiscalMestreRepository extends JpaRepository<NotaFiscalMestre, Integer> {

}



