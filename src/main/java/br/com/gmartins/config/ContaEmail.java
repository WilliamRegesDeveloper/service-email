package br.com.gmartins.config;

public class ContaEmail{

	public String getProtocol() {
		return "imaps";
	}

	public String getHost() {
		return "imap.terra.com.br";
	}

	public String getPort() {
		return "587";
	}

	public String getUserName() {
		//return "informatica@gmartinslogistica.com.br";
		return "nfe@gmartinslogistica.com.br";
	}

	public String getPassword() {
		//return "informatica10";
		return "nfegmlt2017";
	}
	
	public boolean getStarttls() {
		return true;
	}

}
