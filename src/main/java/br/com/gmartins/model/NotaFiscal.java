package br.com.gmartins.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="NOTAFISCAL")
public class NotaFiscal {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ")
	@SequenceGenerator(name = "GEN_SEQ", sequenceName = "SEQNOTAENTRADACLIENTE", allocationSize = 1)
	@Column
	private Integer Id;
    
	/****************Informaçãos da Nota Fiscal********************/
	@Column
	private String notaFiscal;
	
	@Column 
	private String chaveNfe;
	
	@Column 
	private String dataEmissao;
	
	@Column 
	private String tipoNfe;
	
	
	/*************************Emitente*****************************/
	@Column
	private String emiCnpj;
	
	@Column
	private String emiRazao;
	
	@Column
	private String emiFantasia;
	
	@Column
	private String emiEndereco;
	
	@Column
	private String emiNum;
	
	@Column
	private String emiBairro;
	
	@Column
	private String emiCodMun;
	
	@Column
	private String emiMunicipio;
	
	@Column
	private String emiUf;
	
	@Column
	private String emiCep;
	
	@Column
	private String emiFone;
	
	@Column
	private String emiIe;
	
	/***************************Destinatário*****************************/
	@Column
	private String desCnpj;
	
	@Column
	private String desRazao;
	
	@Column
	private String desFantasia;
	
	@Column
	private String desEndereco;
	
	@Column
	private String desNum;
	
	@Column
	private String desBairro;
	
	@Column
	private String desCodMun;
	
	@Column
	private String desMunicipio;
	
	@Column
	private String desUf;
	
	@Column
	private String desCep;
	
	@Column
	private String desFone;
	
	@Column
	private String desIe;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_nota", fetch = FetchType.LAZY)
	private List<NotaFiscalItens> itensNota;
		
	public NotaFiscal() {
		
	}
	
	public NotaFiscal(String notaFiscal, String chaveNfe, String dataEmissao, String tipoNfe, String emiCnpj,
			String emiRazao, String emiFantasia, String emiEndereco, String emiNum, String emiBairro, String emiCodMun,
			String emiMunicipio, String emiUf, String emiCep, String emiFone, String emiIe, String desCnpj,
			String desRazao, String desFantasia, String desEndereco, String desNum, String desBairro, String desCodMun,
			String desMunicipio, String desUf, String desCep, String desFone, String desIe) {
		this.notaFiscal = notaFiscal;
		this.chaveNfe = chaveNfe;
		this.dataEmissao = dataEmissao;
		this.tipoNfe = tipoNfe;
		this.emiCnpj = emiCnpj;
		this.emiRazao = emiRazao;
		this.emiFantasia = emiFantasia;
		this.emiEndereco = emiEndereco;
		this.emiNum = emiNum;
		this.emiBairro = emiBairro;
		this.emiCodMun = emiCodMun;
		this.emiMunicipio = emiMunicipio;
		this.emiUf = emiUf;
		this.emiCep = emiCep;
		this.emiFone = emiFone;
		this.emiIe = emiIe;
		this.desCnpj = desCnpj;
		this.desRazao = desRazao;
		this.desFantasia = desFantasia;
		this.desEndereco = desEndereco;
		this.desNum = desNum;
		this.desBairro = desBairro;
		this.desCodMun = desCodMun;
		this.desMunicipio = desMunicipio;
		this.desUf = desUf;
		this.desCep = desCep;
		this.desFone = desFone;
		this.desIe = desIe;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getChaveNfe() {
		return chaveNfe;
	}

	public void setChaveNfe(String chaveNfe) {
		this.chaveNfe = chaveNfe;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getTipoNfe() {
		return tipoNfe;
	}

	public void setTipoNfe(String tipoNfe) {
		this.tipoNfe = tipoNfe;
	}

	public String getEmiCnpj() {
		return emiCnpj;
	}

	public void setEmiCnpj(String emiCnpj) {
		this.emiCnpj = emiCnpj;
	}

	public String getEmiRazao() {
		return emiRazao;
	}

	public void setEmiRazao(String emiRazao) {
		this.emiRazao = emiRazao;
	}

	public String getEmiFantasia() {
		return emiFantasia;
	}

	public void setEmiFantasia(String emiFantasia) {
		this.emiFantasia = emiFantasia;
	}

	public String getEmiEndereco() {
		return emiEndereco;
	}

	public void setEmiEndereco(String emiEndereco) {
		this.emiEndereco = emiEndereco;
	}

	public String getEmiNum() {
		return emiNum;
	}

	public void setEmiNum(String emiNum) {
		this.emiNum = emiNum;
	}

	public String getEmiBairro() {
		return emiBairro;
	}

	public void setEmiBairro(String emiBairro) {
		this.emiBairro = emiBairro;
	}

	public String getEmiCodMun() {
		return emiCodMun;
	}

	public void setEmiCodMun(String emiCodMun) {
		this.emiCodMun = emiCodMun;
	}

	public String getEmiMunicipio() {
		return emiMunicipio;
	}

	public void setEmiMunicipio(String emiMunicipio) {
		this.emiMunicipio = emiMunicipio;
	}

	public String getEmiUf() {
		return emiUf;
	}

	public void setEmiUf(String emiUf) {
		this.emiUf = emiUf;
	}

	public String getEmiCep() {
		return emiCep;
	}

	public void setEmiCep(String emiCep) {
		this.emiCep = emiCep;
	}

	public String getEmiFone() {
		return emiFone;
	}

	public void setEmiFone(String emiFone) {
		this.emiFone = emiFone;
	}

	public String getEmiIe() {
		return emiIe;
	}

	public void setEmiIe(String emiIe) {
		this.emiIe = emiIe;
	}

	public String getDesCnpj() {
		return desCnpj;
	}

	public void setDesCnpj(String desCnpj) {
		this.desCnpj = desCnpj;
	}

	public String getDesRazao() {
		return desRazao;
	}

	public void setDesRazao(String desRazao) {
		this.desRazao = desRazao;
	}

	public String getDesFantasia() {
		return desFantasia;
	}

	public void setDesFantasia(String desFantasia) {
		this.desFantasia = desFantasia;
	}

	public String getDesEndereco() {
		return desEndereco;
	}

	public void setDesEndereco(String desEndereco) {
		this.desEndereco = desEndereco;
	}

	public String getDesNum() {
		return desNum;
	}

	public void setDesNum(String desNum) {
		this.desNum = desNum;
	}

	public String getDesBairro() {
		return desBairro;
	}

	public void setDesBairro(String desBairro) {
		this.desBairro = desBairro;
	}

	public String getDesCodMun() {
		return desCodMun;
	}

	public void setDesCodMun(String desCodMun) {
		this.desCodMun = desCodMun;
	}

	public String getDesMunicipio() {
		return desMunicipio;
	}

	public void setDesMunicipio(String desMunicipio) {
		this.desMunicipio = desMunicipio;
	}

	public String getDesUf() {
		return desUf;
	}

	public void setDesUf(String desUf) {
		this.desUf = desUf;
	}

	public String getDesCep() {
		return desCep;
	}

	public void setDesCep(String desCep) {
		this.desCep = desCep;
	}

	public String getDesFone() {
		return desFone;
	}

	public void setDesFone(String desFone) {
		this.desFone = desFone;
	}

	public String getDesIe() {
		return desIe;
	}

	public void setDesIe(String desIe) {
		this.desIe = desIe;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public List<NotaFiscalItens> getNotaFiscalItens() {
		return itensNota;
	}

	public void setNotaFiscalItens(List<NotaFiscalItens> notaFiscalItens) {
		this.itensNota = notaFiscalItens;
		
		for(NotaFiscalItens detalhe : notaFiscalItens){
			detalhe.setNotaFiscal(this);
		}
	}
	
	
	
}
