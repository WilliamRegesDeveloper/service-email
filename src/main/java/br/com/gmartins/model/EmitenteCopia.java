package br.com.gmartins.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ARQUIVOXML")
public class EmitenteCopia {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ")
	@SequenceGenerator(name = "GEN_SEQ", sequenceName = "ARQUIVO_XML", allocationSize = 1)
	@Column
	private Long Id;
    
	@Column
	private String cnpj;
	
	@Column
	private String nota;

	public EmitenteCopia() {
		
	}
	public EmitenteCopia(String emiCnpj, String nfe) {
		this.cnpj = emiCnpj;
		this.nota = nfe;
	}
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}
	
}
