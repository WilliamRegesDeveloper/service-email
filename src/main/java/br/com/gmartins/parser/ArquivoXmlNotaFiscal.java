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

import br.com.gmartins.model.NotaFiscalItens;
import br.com.gmartins.model.NotaFiscal;
import br.com.gmartins.repository.NotaFiscalItensRepository;
import br.com.gmartins.repository.NotaFiscalRepository;

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
			 
			 /*********************************Identificação*******************************************/
			 String notaFiscal  = document.getElementsByTagName("nNF").item(0).getTextContent();
			 String chaveNfe    = document.getElementsByTagName("chNFe").item(0).getTextContent();
			 String dataEmissao = document.getElementsByTagName("dhEmi").item(0).getTextContent();
			 String tipoNfe     = document.getElementsByTagName("tpNF").item(0).getTextContent();
			 
			 System.out.println(String.format("%s %s %s %s", notaFiscal, chaveNfe, dataEmissao, tipoNfe));
			 
			 /************************************Emitente*********************************************/
			 String emiCnpj       = document.getElementsByTagName("CNPJ").item(0).getTextContent();
		     String emiRazao  	  = document.getElementsByTagName("xNome").item(0).getTextContent();
		     String emiFantasia   = document.getElementsByTagName("xFant").item(0).getTextContent();
		     String emiEndereco   = document.getElementsByTagName("xLgr").item(0).getTextContent();
		     String emiNum  	  = document.getElementsByTagName("nro").item(0).getTextContent();
		     String emiBairro  	  = document.getElementsByTagName("xBairro").item(0).getTextContent();
		     String emiCodMun  	  = document.getElementsByTagName("cMun").item(0).getTextContent();
		     String emiMunicipio  = document.getElementsByTagName("xMun").item(0).getTextContent();
		     String emiUf	  	  = document.getElementsByTagName("UF").item(0).getTextContent();
		     String emiCep 		  = document.getElementsByTagName("CEP").item(0).getTextContent();
		     String emiFone  	  = document.getElementsByTagName("fone").item(0).getTextContent();
		     String emiIe  		  = document.getElementsByTagName("IE").item(0).getTextContent();
		     
		     System.out.println(String.format("%s %s %s %s %s %s %s %s %s %s %s", emiCnpj, emiRazao, emiFantasia, emiEndereco, 
		    		 emiNum , emiBairro , emiCodMun , emiMunicipio, emiUf , emiCep, emiFone, emiIe));
		
		     /*********************************Destinatário********************************************/
			 String desCnpj       = document.getElementsByTagName("CNPJ").item(1).getTextContent();
		     String desRazao  	  = document.getElementsByTagName("xNome").item(1).getTextContent();
		     //String desFantasia   = document.getElementsByTagName("xFant").item(1).getTextContent();
		     String desFantasia = "teste";
		     String desEndereco   = document.getElementsByTagName("xLgr").item(1).getTextContent();
		     String desNum  	  = document.getElementsByTagName("nro").item(1).getTextContent();
		     String desBairro  	  = document.getElementsByTagName("xBairro").item(1).getTextContent();
		     String desCodMun  	  = document.getElementsByTagName("cMun").item(1).getTextContent();
		     String desMunicipio  = document.getElementsByTagName("xMun").item(1).getTextContent();
		     String desUf	  	  = document.getElementsByTagName("UF").item(1).getTextContent();
		     String desCep 		  = document.getElementsByTagName("CEP").item(1).getTextContent();
		     String desFone  	  = document.getElementsByTagName("fone").item(1).getTextContent();
		     String desIe  		  = document.getElementsByTagName("IE").item(1).getTextContent();
		     
		     System.out.println(String.format("%s %s %s %s %s %s %s %s %s %s %s", desCnpj, desRazao, desFantasia, desEndereco, 
		    		 desNum , desBairro , desCodMun , desMunicipio, desUf , desCep, desFone, desIe));
				
		     /********************************Pesistindo Objeto***************************************/    
		     
		     NotaFiscal nota = new NotaFiscal(notaFiscal, chaveNfe, dataEmissao, tipoNfe,  emiCnpj, emiRazao,  emiFantasia,  emiEndereco,  
		    		 									emiNum,  emiBairro,  emiCodMun, emiMunicipio,  emiUf,  emiCep,  emiFone,  emiIe,  desCnpj,
		    		 									desRazao,  desFantasia,  desEndereco,  desNum,  desBairro,  desCodMun,	desMunicipio,  
		    		 									desUf,  desCep,  desFone,  desIe);
	          
		     /*********************************Produtos**********************************************/
	          NodeList produtos = document.getElementsByTagName("prod");
	          for (int i = 0; i < produtos.getLength(); i++) {
	          	Element produto = (Element) produtos.item(i);
	  			
	          	String codProduto    =  produto.getElementsByTagName("cProd").item(0).getTextContent();
	  			String descProduto   =  produto.getElementsByTagName("xProd").item(0).getTextContent(); 
	  			String unidMedida    =  produto.getElementsByTagName("uTrib").item(0).getTextContent();
	  			//double vlrUnitario   =  Double.parseDouble(produto.getElementsByTagName("vUnCom").item(0).getTextContent());
	  			//double qtdItem       =  Double.parseDouble(produto.getElementsByTagName("qCom").item(0).getTextContent());
	  			//double vlrTotProduto =  Double.parseDouble(produto.getElementsByTagName("vProd").item(0).getTextContent());
	  			
	  			String vlrUnitario   =  produto.getElementsByTagName("vUnCom").item(0).getTextContent();
	  			String qtdItem       =  produto.getElementsByTagName("qCom").item(0).getTextContent();
	  			String vlrTotProduto =  produto.getElementsByTagName("vProd").item(0).getTextContent();
	  			
	  		    System.out.println(String.format("%s %s %s %s %s %s", codProduto, descProduto, unidMedida, vlrUnitario, qtdItem , vlrTotProduto));
	  		   
	  		    
	  		    repNota.save(nota);
	  		
	  		  
	  		    NotaFiscalItens itens = new NotaFiscalItens(codProduto, descProduto, unidMedida, vlrUnitario,  qtdItem, vlrTotProduto);
	  		   
	  		    nota.setNotaFiscalItens(Arrays.asList(itens));
	  	
	  		    repNotaItens.save(nota.getNotaFiscalItens());
	  		     
	  		 
	          }
	          
	          /*Transportadora e quantidade de volumes*/
	           NodeList volumes = document.getElementsByTagName("vol");
	           for (int i = 0; i < volumes.getLength(); i++) {
	        	  Element volume = (Element) volumes.item(i);
	        	  
	        	  String trasVol  	=  volume.getElementsByTagName("qVol").item(0).getTextContent();
	        	  String trasEsp    =  volume.getElementsByTagName("esp").item(0).getTextContent();
	        	  String trasPesol  =  volume.getElementsByTagName("pesoL").item(0).getTextContent();
	        	  String trasPesob  =  volume.getElementsByTagName("pesoB").item(0).getTextContent();
	        	  
	        	  System.out.println(String.format("%s %s %s %s", trasVol, trasEsp, trasPesol, trasPesob));
			}
	          
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
	

	
