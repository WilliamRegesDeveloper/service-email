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
	@SequenceGenerator(name = "GEN_SEQ", sequenceName = "SEQNOTAFISCALITENS", allocationSize = 1)
	@Column
	private Integer Id;
		
	@Column 
	private String codProduto;
	
	@Column
	private String descProduto;
	
	@Column
	private String unidMedida;
	
	@Column 
	private double vlrUnitario;
	
	@Column 
	private double qtdItem;
	
	@Column 
	private double vlrTotProduto;
	
	@ManyToOne
	private NotaFiscal id_nota;
	
	
	public NotaFiscalItens() {
		
	}

	public NotaFiscalItens(String codProduto, String descProduto, String unidMedida, double vlrUnitario, double qtdItem, double vlrTotProduto) {
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

	public double getVlrUnitario() {
		return vlrUnitario;
	}

	public void setVlrUnitario(double vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}

	public double getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(double qtdItem) {
		this.qtdItem = qtdItem;
	}

	public double getVlrTotProduto() {
		return vlrTotProduto;
	}

	public void setVlrTotProduto(double vlrTotProduto) {
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
