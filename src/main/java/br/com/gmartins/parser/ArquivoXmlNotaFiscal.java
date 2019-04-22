package br.com.gmartins.parser;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import br.com.gmartins.model.Emitente;
import br.com.gmartins.repository.EmitenteRepository;

public class ArquivoXmlNotaFiscal {

	
	@Autowired
    private EmitenteRepository repository;
	
	public void Salvar(String arquivoXml) {
		
		try {
			

			 DocumentBuilderFactory nfe =  DocumentBuilderFactory.newInstance(); 
			 DocumentBuilder builder = nfe.newDocumentBuilder();
			 Document document = builder.parse(new InputSource(new StringReader(arquivoXml))); 
			 
			 String numNota     = document.getElementsByTagName("nNF").item(0).getTextContent();
			 String dataEmissao = document.getElementsByTagName("dhEmi").item(0).getTextContent();
			 String tipoNfe     = document.getElementsByTagName("tpNF").item(0).getTextContent();
			 
			 String ecnpjCpf      = document.getElementsByTagName("CNPJ").item(0).getTextContent();
		     String erazaoSocial  = document.getElementsByTagName("xNome").item(0).getTextContent();
		     String enomeFantasia = document.getElementsByTagName("xNome").item(0).getTextContent();
		     String einsEstadual  = document.getElementsByTagName("IE").item(0).getTextContent();
			
		   	 System.out.println(numNota +" "+ dataEmissao  +" "+ tipoNfe +""+ecnpjCpf);

		   	 Emitente emitente = new Emitente(ecnpjCpf,numNota );
		   	
	
		   	 //System.out.println(emitente);
	          this.repository.save(emitente);
			
		}catch (Exception e) {
			e.printStackTrace();
			}
		
	}

}
	

	
