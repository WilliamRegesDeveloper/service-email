package br.com.gmartins.config;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gmartins.service.ReceberEmailComAnexoService;

@Component
public class Sincronizador {
 
	public static final long TEMPO = (100 * 60);
    
	@Autowired
	private ReceberEmailComAnexoService arquivo;
	
	public void tempo() {
        
		System.out.println("Inicio...");
        
        Timer timer = null;
         
        if (timer == null) {
        	
        	timer = new Timer();
            
        	TimerTask tarefa = new TimerTask() {
            
            	@Override
    			public void run() {
    				System.out.println("Serviço em Operação...");
    					arquivo.receberEmail();
    			}
    		};
    		
    		timer.scheduleAtFixedRate(tarefa, 0, TEMPO);

        }
    }
}






