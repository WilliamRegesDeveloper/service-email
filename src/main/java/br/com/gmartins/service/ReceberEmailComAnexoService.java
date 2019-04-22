package br.com.gmartins.service;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gmartins.config.ContaEmail;
import br.com.gmartins.parser.ArquivoXmlNotaFiscal;

@Service
public class ReceberEmailComAnexoService  { 
    
	@Autowired
	private ArquivoXmlNotaFiscal xml;
	
	public void receberEmail(){
    
		ContaEmail conta = new ContaEmail();
	  
		Properties props = new Properties();
			props.put("mail.store.protocol", conta.getProtocol());
			props.put("mail.imap.host", conta.getHost());
			props.put("mail.imap.port", conta.getPort());
			props.put("mail.imap.starttls.enable", conta.getStarttls());
 
		Session session = Session.getInstance(props);
 
    try {
        Store store = session.getStore("imaps");
	    store.connect(conta.getHost(), conta.getUserName(), conta.getPassword());
 
	    /**
	     * Criação do objeto Folder para abertura da caixa de e-mail
	     */
	
	    Folder emailFolder = store.getFolder("INBOX");
	    emailFolder.open(Folder.READ_WRITE);
 
	    /**
	     * Recuperando as mensagens do objeto Folder, buscar somente os e-mails não lidos
	     */
	
	    Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false)); 
	
	    for (int i = 0; i < messages.length; i++) {
	    
	    	Object obj = messages[i].getContent();
	     
	    	if (obj != null && obj instanceof Multipart ) {
	      
	    		Multipart multipart = (Multipart) obj;
	    	 
	    		for(int k = 0; k < multipart.getCount(); k++) {
	    			
	    			BodyPart bodyPart = multipart.getBodyPart(k); 
	    			/**
	    			 * Condicional para recuperar anexos com arquivos XML
	    			 */
	    			
	    			if( bodyPart.isMimeType("text/xml") || 
	    				 bodyPart.isMimeType("multipart/mixed") ||
	    				 	bodyPart.isMimeType("application/xml")){
	    			 	
	    			 Scanner scanner = new Scanner(bodyPart.getInputStream());
	    			 	while (scanner.hasNextLine()) {
	    			 		
	    			 		xml.Salvar(scanner.nextLine());
	    			 	}
	    			 scanner.close();	
	    			}
	    		}
	    	}  
	    }
	    emailFolder.close(false);
	   		store.close();
	  } catch (Exception e) {
	      e.printStackTrace();
	  }

	}	
}

