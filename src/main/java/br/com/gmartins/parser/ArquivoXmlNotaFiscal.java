package br.com.gmartins.parser;

import java.io.StringReader;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import br.com.gmartins.model.NotaFiscal;
import br.com.gmartins.model.NotaFiscalItens;
import br.com.gmartins.repository.NotaFiscalItensRepository;
import br.com.gmartins.repository.NotaFiscalRepository;

/**
 * 
 * @author Edson Cavalcanti
 * @category Serialização do arquivo XML da nota fiscal
 */
@Service
public class ArquivoXmlNotaFiscal {	
	
	@Autowired
    private NotaFiscalRepository repNota;
	
	@Autowired
    private NotaFiscalItensRepository repNotaItens;
	
	public void Salvar(String arquivoXml) {
		
		try {
			 DocumentBuilderFactory nfe =  DocumentBuilderFactory.newInstance(); 
			 DocumentBuilder builder = nfe.newDocumentBuilder();
			 Document document = builder.parse(new InputSource(new StringReader(arquivoXml))); 
			 document.getDocumentElement().normalize(); //novo
			 			 
			 
			 /***Validação pela Chave de Acesso***/
			 String chaveNfe    = document.getElementsByTagName("chNFe").item(0).getTextContent();
			 
			 NotaFiscal validaChave = repNota.findByChaveDeAcesso(chaveNfe); // Consultando no banco
			 
			 if (validaChave != null && validaChave.getChaveNfe().equals(chaveNfe)) {
				 System.out.println("Nota Fiscal:  " + validaChave.getChaveNfe() + "  Importada Anteriormente");
			 }else {
			 
			
			 String notaFiscal  = document.getElementsByTagName("nNF").item(0).getTextContent();
			 String dataEmissao = document.getElementsByTagName("dhEmi").item(0).getTextContent();
			 String tipoNfe     = document.getElementsByTagName("tpNF").item(0).getTextContent();
		     double valorTotalNota  = Double.parseDouble((document.getElementsByTagName("vNF").item(0).getTextContent()));
		   			 
			 /***Emitente***/
			 String emiCnpj       = document.getElementsByTagName("CNPJ").item(0).getTextContent();
		     String emiRazao  	  = document.getElementsByTagName("xNome").item(0).getTextContent().toUpperCase();
		     String emiFantasia   = document.getElementsByTagName("xFant").item(0).getTextContent().toUpperCase();
		     String emiEndereco   = document.getElementsByTagName("xLgr").item(0).getTextContent().toUpperCase();
		     String emiNum  	  = document.getElementsByTagName("nro").item(0).getTextContent().toUpperCase();
		     String emiBairro  	  = document.getElementsByTagName("xBairro").item(0).getTextContent().toUpperCase();
		     String emiCodMun  	  = document.getElementsByTagName("cMun").item(0).getTextContent();
		     String emiMunicipio  = document.getElementsByTagName("xMun").item(0).getTextContent().toUpperCase();
		     String emiUf	  	  = document.getElementsByTagName("UF").item(0).getTextContent();
		     String emiCep 		  = document.getElementsByTagName("CEP").item(0).getTextContent();
		     String emiFone  	  = document.getElementsByTagName("fone").item(0).getTextContent();
		     String emiIe  		  = document.getElementsByTagName("IE").item(0).getTextContent();
		  
		     /***Destinatário***/
			 String desCnpj       = document.getElementsByTagName("CNPJ").item(1).getTextContent();
		     String desRazao  	  = document.getElementsByTagName("xNome").item(1).getTextContent().toUpperCase();
		     String desFantasia   = "*****";//document.getElementsByTagName("xFant").item(1).getTextContent();
		     String desEndereco   = document.getElementsByTagName("xLgr").item(1).getTextContent().toUpperCase();
		     String desNum  	  = document.getElementsByTagName("nro").item(1).getTextContent().toUpperCase();
		     String desBairro  	  = document.getElementsByTagName("xBairro").item(1).getTextContent().toUpperCase();
		     String desCodMun  	  = document.getElementsByTagName("cMun").item(1).getTextContent();
		     String desMunicipio  = document.getElementsByTagName("xMun").item(1).getTextContent().toUpperCase();
		     String desUf	  	  = document.getElementsByTagName("UF").item(1).getTextContent();
		     String desCep 		  = document.getElementsByTagName("CEP").item(1).getTextContent();
		     String desFone  	  = "*";//document.getElementsByTagName("fone").item(1).getTextContent();
		     String desIe  		  = document.getElementsByTagName("IE").item(1).getTextContent();
		      
		     /***Instância da Classe Nota Fiscal***/   
		     NotaFiscal nota = new NotaFiscal(notaFiscal, chaveNfe, dataEmissao, tipoNfe, emiCnpj, emiRazao,  emiFantasia,  emiEndereco, 
		    		                          emiNum,  emiBairro,  emiCodMun, emiMunicipio,  emiUf, emiCep,  emiFone,  emiIe,  desCnpj,
		    		 									desRazao,  desFantasia,  desEndereco,  desNum,  desBairro,  desCodMun,desMunicipio,  
		    		 									desUf, desCep,  desFone,  desIe, valorTotalNota);
		     
		     /***Quantidade de Volumes***/
	           NodeList volumes = document.getElementsByTagName("vol");
	           for (int i = 0; i < volumes.getLength(); i++) {
	        	  Element volume = (Element) volumes.item(i);
	        	  
	        	  double quantidadeVolumes  = Double.parseDouble((volume.getElementsByTagName("qVol").item(0).getTextContent()));
	        	  double pesoLiquido  = Double.parseDouble((volume.getElementsByTagName("pesoL").item(0).getTextContent()));
	        	  double pesoBruto  = Double.parseDouble(volume.getElementsByTagName("pesoB").item(0).getTextContent());
	        	 
	        	  nota.setQuantidadeVolumes(nota.getQuantidadeVolumes() + quantidadeVolumes);
	        	  nota.setPesoLiquido(nota.getPesoLiquido() + pesoLiquido);
	        	  nota.setPesoBruto(nota.getPesoBruto() + pesoBruto); 
	           }
		     
	         /***Produtos***/
	          NodeList produtos = document.getElementsByTagName("prod");
	          for (int i = 0; i < produtos.getLength(); i++) {
	          	Element produto = (Element) produtos.item(i);
	  			
	          	String codProduto    =  produto.getElementsByTagName("cProd").item(0).getTextContent().toUpperCase();
	  			String descProduto   =  produto.getElementsByTagName("xProd").item(0).getTextContent().toUpperCase(); 
	  			String unidMedida    =  produto.getElementsByTagName("uTrib").item(0).getTextContent().toUpperCase();
	  			double vlrUnitario   =  Double.parseDouble(produto.getElementsByTagName("vUnCom").item(0).getTextContent());
	  			double qtdItem       =  Double.parseDouble(produto.getElementsByTagName("qCom").item(0).getTextContent());
	  			double vlrTotProduto =  Double.parseDouble(produto.getElementsByTagName("vProd").item(0).getTextContent());
	  			
	  			nota.setQuantidadeItens(nota.getQuantidadeItens()+qtdItem);   
	  		    
	  		    repNota.save(nota); //Persiste Nota Fiscal
	  		
	  		  
	  		    NotaFiscalItens itens = new NotaFiscalItens(codProduto, descProduto, unidMedida, vlrUnitario,  qtdItem, vlrTotProduto);
	  		   
	  		    nota.setNotaFiscalItens(Arrays.asList(itens)); 
	  	
	  		    repNotaItens.save(nota.getNotaFiscalItens()); //Persiste Itens da Nota Fiscal
	          }
		}  // fim do condicional
	      
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}

	

	
