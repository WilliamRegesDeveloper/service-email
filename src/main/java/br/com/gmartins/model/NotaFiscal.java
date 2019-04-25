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
	@SequenceGenerator(name = "GEN_SEQ", sequenceName = "SEQNOTAFISCAL", allocationSize = 1)
	@Column
	private Integer Id;
    
	/***Informaçãos da Nota Fiscal***/
	
	@Column(nullable = false, length=20)
	private String notaFiscal;
	
	@Column(nullable = false, length=44) 
	private String chaveNfe;
	
	@Column (nullable = false, length=25)
	private String dataEmissao;
	
	@Column(length=1) 
	private String tipoNfe;
	
	/***Emitente***/
	@Column(nullable = false , length = 18)
	private String emiCnpj;
	
	@Column(nullable = false, length = 60)
	private String emiRazao;
	
	@Column(length = 20)
	private String emiFantasia;
	
	@Column(length = 60)
	private String emiEndereco;
	
	@Column(length = 6)
	private String emiNum;
	
	@Column(length = 30)
	private String emiBairro;
	
	@Column(length = 10)
	private String emiCodMun;
	
	@Column(length = 20)
	private String emiMunicipio;
	
	@Column(length = 2)
	private String emiUf;
	
	@Column(length = 8)
	private String emiCep;
	
	@Column(length = 20)
	private String emiFone;
	
	@Column(length = 18)
	private String emiIe;
	
	/***Destinatário****/
	@Column(nullable = false , length = 18)
	private String desCnpj;
	
	@Column(nullable = false, length = 60)
	private String desRazao;
	
	@Column(length = 20)
	private String desFantasia;
	
	@Column(length = 60)
	private String desEndereco;
	
	@Column(length = 6)
	private String desNum;
	
	@Column(length = 30)
	private String desBairro;
	
	@Column(length = 10)
	private String desCodMun;
	
	@Column(length = 20)
	private String desMunicipio;
	
	@Column(length = 2)
	private String desUf;
	
	@Column(length = 8)
	private String desCep;
	
	@Column(length = 20)
	private String desFone;
	
	@Column(length = 18)
	private String desIe;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_nota", fetch = FetchType.LAZY)
	private List<NotaFiscalItens> itensNota;
	
	@Column(precision = 12, scale = 2)
	private double valorTotalNota;
	
	@Column(precision = 12, scale = 2)
	private double quantidadeVolumes;
	
	@Column(precision = 16, scale = 2)
	private double quantidadeItens;
	
	@Column(precision = 18, scale = 2)
	private double pesoLiquido;
	
	@Column(precision = 18, scale = 2)
	private double pesoBruto;
	
	public NotaFiscal() {
		
	}
	
	public NotaFiscal(String notaFiscal, String chaveNfe, String dataEmissao, String tipoNfe, String emiCnpj,
			String emiRazao, String emiFantasia, String emiEndereco, String emiNum, String emiBairro, String emiCodMun,
			String emiMunicipio, String emiUf, String emiCep, String emiFone, String emiIe, String desCnpj,
			String desRazao, String desFantasia, String desEndereco, String desNum, String desBairro, String desCodMun,
			String desMunicipio, String desUf, String desCep, String desFone, String desIe,
			double valorTotalNota) {
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
	    this.valorTotalNota =  valorTotalNota;
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
	
	/*Set no ID em todos os itens da lista */
	public void setNotaFiscalItens(List<NotaFiscalItens> notaFiscalItens) {
		this.itensNota = notaFiscalItens;
		
		for(NotaFiscalItens detalhe : notaFiscalItens){
			detalhe.setNotaFiscal(this);
		}
	}

	public double getValorTotalNota() {
		return valorTotalNota;
	}

	public void setValorTotalNota(double valorTotalNota) {
		this.valorTotalNota = valorTotalNota;
	}

	public double getQuantidadeVolumes() {
		return quantidadeVolumes;
	}

	public void setQuantidadeVolumes(double quantidadeVolumes) {
		this.quantidadeVolumes = quantidadeVolumes;
	}

	public double getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(double quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}

	public double getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public double getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	
}
