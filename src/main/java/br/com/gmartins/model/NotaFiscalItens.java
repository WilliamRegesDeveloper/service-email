package br.com.gmartins.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="NOTAFISCALITENS")
public class NotaFiscalItens {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ")
	@SequenceGenerator(name = "GEN_SEQ", sequenceName = "SEQNOTAENTRADACLIENTEFILHO", allocationSize = 1)
	@Column
	private Integer Id;
		
	@Column 
	private String codProduto;
	
	@Column
	private String descProduto;
	
	@Column
	private String unidMedida;
	
	@Column 
	private String vlrUnitario;
	
	@Column 
	private String qtdItem;
	
	@Column 
	private String vlrTotProduto;
	
	
	@ManyToOne
	private NotaFiscal id_nota;
	
	/****************Produtos da Nota Fiscal********************/
	
	public NotaFiscalItens() {
		
	}

	public NotaFiscalItens(String codProduto, String descProduto, String unidMedida, String vlrUnitario, String qtdItem,
			String vlrTotProduto) {
		this.codProduto = codProduto;
		this.descProduto = descProduto;
		this.unidMedida = unidMedida;
		this.vlrUnitario = vlrUnitario;
		this.qtdItem = qtdItem;
		this.vlrTotProduto = vlrTotProduto;
	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public String getUnidMedida() {
		return unidMedida;
	}

	public void setUnidMedida(String unidMedida) {
		this.unidMedida = unidMedida;
	}

	public String getVlrUnitario() {
		return vlrUnitario;
	}

	public void setVlrUnitario(String vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}

	public String getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(String qtdItem) {
		this.qtdItem = qtdItem;
	}

	public String getVlrTotProduto() {
		return vlrTotProduto;
	}

	public void setVlrTotProduto(String vlrTotProduto) {
		this.vlrTotProduto = vlrTotProduto;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public NotaFiscal getNotaFiscal() {
		return id_nota;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.id_nota = notaFiscal;
	}
	
}
